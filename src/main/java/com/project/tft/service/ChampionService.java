package com.project.tft.service;

import com.project.tft.controller.data.CreateChampionRequest;
import com.project.tft.controller.data.CreateChampionResponse;
import com.project.tft.entity.Champion;
import com.project.tft.entity.FileEntity;
import com.project.tft.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChampionService {

    @Autowired
    private ChampionRepository championRepository;

    @Autowired
    private FileService fileService;

    public List<CreateChampionResponse> getAll() {
        Iterable<Champion> champions = championRepository.findByOrderByNameAsc();

        List<CreateChampionResponse> response = new ArrayList<>();

        for (Champion champion : champions) {
            CreateChampionResponse responseChampion = new CreateChampionResponse();
            responseChampion.setId(champion.getId());
            responseChampion.setName(champion.getName());
            responseChampion.setOrigin(champion.getOrigin());
            responseChampion.setOrigin2(champion.getOrigin2());
            responseChampion.setClassName(champion.getClassName());
            responseChampion.setClassName2(champion.getClassName2());
            responseChampion.setCost(champion.getCost());
            responseChampion.setHealth(champion.getHealth());
            responseChampion.setAd(champion.getAd());
            responseChampion.setAtkRange(champion.getAtkRange());
            responseChampion.setAtkSpeed(champion.getAtkSpeed());
            responseChampion.setArmor(champion.getArmor());
            responseChampion.setSkillName(champion.getSkillName());
            responseChampion.setSkillText(champion.getSkillText());
            responseChampion.setBaseMana(champion.getBaseMana());
            responseChampion.setMaxMana(champion.getMaxMana());
            var champImg = champion.getChampImg();
            responseChampion.setChampImg(champImg.getId());
            response.add(responseChampion);
        }
        return response;
    }

    public CreateChampionResponse getChampion(int id) {
        Champion champion = championRepository.findById(id).orElseThrow();

        CreateChampionResponse response = new CreateChampionResponse();
        response.setId(champion.getId());
        response.setAd(champion.getAd());
        response.setArmor(champion.getArmor());
        response.setAtkRange(champion.getAtkRange());
        response.setAtkSpeed(champion.getAtkSpeed());
        response.setBaseMana(champion.getBaseMana());
        var champImg = champion.getChampImg();
        response.setChampImg(champImg.getId());
        response.setClassName(champion.getClassName());
        response.setClassName2(champion.getClassName2());
        response.setCost(champion.getCost());
        response.setHealth(champion.getHealth());
//        response.setMResist(champion.getmResist());
        response.setMaxMana(champion.getMaxMana());
        response.setName(champion.getName());
        response.setOrigin(champion.getOrigin());
        response.setOrigin2(champion.getOrigin2());
        response.setSkillName(champion.getSkillName());
        response.setSkillText(champion.getSkillText());

        return response;
    }

    public CreateChampionResponse create(CreateChampionRequest createChampionRequest, String id) {
        Champion champion = new Champion();
        champion.setAd(createChampionRequest.getAd());
        champion.setArmor(createChampionRequest.getArmor());
        champion.setAtkRange(createChampionRequest.getAtkRange());
        champion.setAtkSpeed(createChampionRequest.getAtkSpeed());
        champion.setBaseMana(createChampionRequest.getBaseMana());
        champion.setClassName(createChampionRequest.getClassName());
        champion.setClassName2(createChampionRequest.getClassName2());
        champion.setCost(createChampionRequest.getCost());
        champion.setHealth(createChampionRequest.getHealth());
//        champion.setmResist(createChampionRequest.getMResist());
        champion.setMaxMana(createChampionRequest.getMaxMana());
        champion.setName(createChampionRequest.getName());
        champion.setOrigin(createChampionRequest.getOrigin());
        champion.setOrigin2(createChampionRequest.getOrigin2());
        champion.setSkillName(createChampionRequest.getSkillName());
        champion.setSkillText(createChampionRequest.getSkillText());
        champion.setChampImg(fileService.getFile(id).get());
        champion = championRepository.save(champion);

        CreateChampionResponse response = new CreateChampionResponse();
        response.setId(champion.getId());
        response.setAd(champion.getAd());
        response.setArmor(champion.getArmor());
        response.setAtkRange(champion.getAtkRange());
        response.setAtkSpeed(champion.getAtkSpeed());
        response.setBaseMana(champion.getBaseMana());
        var champImg = champion.getChampImg();
        response.setChampImg(champImg.getId());
        response.setClassName(champion.getClassName());
        response.setClassName2(champion.getClassName2());
        response.setCost(champion.getCost());
        response.setHealth(champion.getHealth());
//        response.setMResist(champion.getmResist());
        response.setMaxMana(champion.getMaxMana());
        response.setName(champion.getName());
        response.setOrigin(champion.getOrigin());
        response.setOrigin2(champion.getOrigin2());
        response.setSkillName(champion.getSkillName());
        response.setSkillText(champion.getSkillText());

        return response;

    }

    public void deleteChampion(int id) {
        championRepository.deleteById(id);
    }
}
