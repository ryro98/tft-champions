package com.project.tft.controller.data;

import com.project.tft.entity.FileEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@Data
public class CreateChampionRequest {
    private int id;
    private String name;
    private Integer cost;
    private String origin;
    private String origin2;
    private String className;
    private String className2;
    private Integer health;
    private Integer ad;
    private Integer atkRange;
    private double atkSpeed;
    private Integer armor;
//    private Integer mResist;
    private String skillName;
    private String skillText;
    private Integer baseMana;
    private Integer maxMana;
    private MultipartFile champImg;
}
