package com.project.tft.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int cost;
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
    @Column(length = 500)
    private String skillText;
    private Integer baseMana;
    private Integer maxMana;

    public FileEntity getChampImg() {
        return champImg;
    }

    public void setChampImg(FileEntity champImg) {
        this.champImg = champImg;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "files_id", referencedColumnName = "id")
    private FileEntity champImg;
//    private FileEntity skillImg;

    @ElementCollection(targetClass = Champion.class)
    public Set<Champion> champions = new HashSet<>();

    public Set<Champion> getChampions() {
        return champions;
    }

    public void setChampions(Set<Champion> champions) {
        this.champions = champions;
    }

    public Champion() {

    }

    public Champion(String name, int cost, String origin, String origin2, String className, String className2, int health, int ad, int atkRange, double atkSpeed, int armor, String skillName, String skillText, int baseMana, int maxMana, FileEntity champImg) {
        this.name = name;
        this.cost = cost;
        this.origin = origin;
        this.origin2 = origin2;
        this.className = className;
        this.className2 = className2;
        this.health = health;
        this.ad = ad;
        this.atkRange = atkRange;
        this.atkSpeed = atkSpeed;
        this.armor = armor;
//        this.mResist = mResist;
        this.skillName = skillName;
        this.skillText = skillText;
        this.baseMana = baseMana;
        this.maxMana = maxMana;
        this.champImg = champImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin2() {
        return origin2;
    }

    public void setOrigin2(String origin2) {
        this.origin2 = origin2;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName2() {
        return className2;
    }

    public void setClassName2(String className2) {
        this.className2 = className2;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int getAtkRange() {
        return atkRange;
    }

    public void setAtkRange(int atkRange) {
        this.atkRange = atkRange;
    }

    public double getAtkSpeed() {
        return atkSpeed;
    }

    public void setAtkSpeed(double atkSpeed) {
        this.atkSpeed = atkSpeed;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

//    public int getmResist() {return mResist;}
//
//    public void setmResist(int mResist) {this.mResist = mResist;}

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillText() {
        return skillText;
    }

    public void setSkillText(String skillText) {
        this.skillText = skillText;
    }

    public int getBaseMana() {
        return baseMana;
    }

    public void setBaseMana(int baseMana) {
        this.baseMana = baseMana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", origin='" + origin + '\'' +
                ", origin2='" + origin2 + '\'' +
                ", className='" + className + '\'' +
                ", className2='" + className2 + '\'' +
                ", health=" + health +
                ", ad=" + ad +
                ", atkRange=" + atkRange +
                ", atkSpeed=" + atkSpeed +
                ", armor=" + armor +
                ", skillName='" + skillName + '\'' +
                ", skillText='" + skillText + '\'' +
                ", baseMana=" + baseMana +
                ", maxMana=" + maxMana +
                ", champImg=" + champImg +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Champion champion = (Champion) o;
        return id == champion.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
