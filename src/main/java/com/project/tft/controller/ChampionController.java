package com.project.tft.controller;

import com.project.tft.controller.data.CreateChampionRequest;
import com.project.tft.controller.data.CreateChampionResponse;
import com.project.tft.entity.Champion;
import com.project.tft.repository.ChampionRepository;
import com.project.tft.repository.FileRepository;
import com.project.tft.service.ChampionService;
import com.project.tft.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @Autowired
    private FileService fileService;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private ChampionRepository championRepository;

    @GetMapping("/champions")
    public String getChampions(Model model) {
//        model.addAttribute("champions", fileService.getAllFiles());
        model.addAttribute("files", fileService.getAllFiles());
        model.addAttribute("champions", championService.getAll());

        return "champions/list";
    }

    @PostMapping("/champions")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createChampion(@RequestBody CreateChampionRequest createChampionRequest, String id) {
        championService.create(createChampionRequest, id);
        return "champions/list";
    }

    @GetMapping("/new")
    public String formChampion(Model model) {
        model.addAttribute("champion", new CreateChampionRequest());
        return "champions/new";
    }

    @PostMapping("/new")
    public String upload(@ModelAttribute CreateChampionRequest createChampionRequest, @RequestParam("file") MultipartFile file, Model model) {
        try {
            String id = fileService.save(file);
            championService.create(createChampionRequest, id);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
            model.addAttribute("champions", championService.getAll());
            return "champions/list";
        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
            return "error";
        }
    }

    @GetMapping(value = "/champions/{id}")
    public String showChampion(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("champion", championService.getChampion(id));
        return "champions/champ";
    }

    @GetMapping("/search")
    public String searchChampions(Model model, @Param("name") String name, @Param("cost") Integer cost, @Param("origin") String origin, @Param("origin2") String origin2, @Param("classname") String classname, @Param("classname2") String classname2) {
        List<CreateChampionResponse> championSet = championService.getAll();

        if (name != null) {
            championSet.removeIf(champion -> !champion.getName().equals(name));
        }

        if (cost != null) {
            championSet.removeIf(champion -> !champion.getCost().equals(cost));
        }

        if (origin != null) {
            championSet.removeIf(champion -> !champion.getOrigin().equals(origin));
        }

        if (origin2 != null) {
            championSet.removeIf(champion -> !champion.getOrigin2().equals(origin2));
        }

        if (classname != null) {
            championSet.removeIf(champion -> !champion.getClassName().equals(classname));
        }

        if (classname2 != null) {
            championSet.removeIf(champion -> !champion.getClassName2().equals(classname2));
        }

        model.addAttribute("champions", championSet);
        return "champions/list";
    }
}
