package com.project.tft.controller;

import com.project.tft.controller.data.CreateChampionRequest;
import com.project.tft.entity.Champion;
import com.project.tft.entity.FileEntity;
import com.project.tft.entity.FileResponse;
import com.project.tft.service.ChampionService;
import com.project.tft.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("files")
public class FilesController {

    @Autowired
    private FileService fileService;

    @Autowired
    private ChampionService championService;

//    @Autowired
//    public FilesController(FileService fileService) {
//        this.fileService = fileService;
//    }

    @PostMapping("/new")
    public String upload(@ModelAttribute CreateChampionRequest createChampionRequest, @RequestParam("file") MultipartFile file) {
        try {
            String id = fileService.save(file);
            championService.create(createChampionRequest, id);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
            return "champions/list";
        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
            return "error";
        }
    }

    @GetMapping
    public List<FileResponse> list() {
        return fileService.getAllFiles()
                .stream()
                .map(this::mapToFileResponse)
                .collect(Collectors.toList());
    }

    private FileResponse mapToFileResponse(FileEntity fileEntity) {
        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/")
                .path(fileEntity.getId())
                .toUriString();
        FileResponse fileResponse = new FileResponse();
        fileResponse.setId(fileEntity.getId());
        fileResponse.setName(fileEntity.getName());
        fileResponse.setContentType(fileEntity.getContentType());
        fileResponse.setSize(fileEntity.getSize());
        fileResponse.setUrl(downloadURL);

        return fileResponse;
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Optional<FileEntity> fileEntityOptional = fileService.getFile(id);

        if (!fileEntityOptional.isPresent()) {
            return ResponseEntity.notFound()
                    .build();
        }

        FileEntity fileEntity = fileEntityOptional.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
                .contentType(MediaType.valueOf(fileEntity.getContentType()))
                .body(fileEntity.getData());
    }

    @ControllerAdvice
    public class RestExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(MaxUploadSizeExceededException.class)
        public ResponseEntity<String> handleMaxSizeException(MaxUploadSizeExceededException exc) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Unable to upload. File is too large!");
        }
    }
}
