package com.project.tft.bootstrap;

import com.project.tft.controller.data.CreateChampionRequest;
import com.project.tft.entity.Champion;
import com.project.tft.entity.FileEntity;
import com.project.tft.repository.ChampionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final ChampionRepository championRepository;

    public BootStrapData(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Champion test = new Champion("Dawid", 15, "origin", "origin2", "class", "class2", 500, 50, 4, 0.60, 50, 50, "skill", "this skill is XD", 50, 50);
        //Champion ahri = new Champion("Ahri", 4, "Syndicate", "", "Arcanist", "", 800, 45, 4, 0.75, 30, 30, "Orb of Deception", "Ahri fires an orb in a 5 hex line, dealing magic damage to all enemies it passes through on the way out and the way back. Enemies already hit by an orb take 60% damage for each subsequent orb. Ahri fires additional orbs for each time she has cast this combat.", 30, 50, );
//        Champion alistar = new Champion("Alistar", 4, "Hextech", "", "Colossus", "", 1400, 90, 1, 0.6, 80, 80, "Pulverize", "Alistar charges at his target, knocking them back for a short distance. Then he slams the ground, dealing magic damage and stunning all nearby enemies for a few seconds.", 85, 170);
//        Champion ashe = new Champion("Ashe", 2, "Syndicate", "", "Sniper", "", 600, 60, 4, 0.7, 20, 20, "Volley", "Ashe fires a volley of arrows centered on her target, dealing % of her Attack Damage as physical damage per arrow and slowing their Attack Speed by 15% for 3 seconds.", 30, 60);
//        Champion blitzcrank = new Champion("Blitzcrank", 2, "Scrap", "", "Bodyguard", "", 650, 65, 1, 0.5, 45, 45, "Rocket Grab", "Blitzcrank pulls the farthest enemy, dealing magic damage and stunning them for 1.5 seconds. His next attack knocks up for 1 second. Allies within range will prefer attacking Blitzcrank's target.", 175, 175);
//        Champion brand = new Champion("Brand", 1, "Debonair", "", "Arcanist", "", 500, 40, 3, 0.65, 20, 20, "Sear", "Brand launches a fireball at the nearest enemy, lighting them ablaze for 4 seconds and dealing magic damage. If the enemy is already on fire, they take bonus magic damage which stuns them for a few seconds.", 0, 20);
//        Champion braum = new Champion("Braum", 4, "Syndicate", "", "Bodyguard", "", 1100, 70, 1, 0.6, 60, 60, "Vault Breaker", "Braum slams his vault door into the ground, creating a fissure towards his target. Enemies within 2 hexes of Braum and those struck by the fissure, are stunned for a few seconds and take magic damage.", 120, 200);
//        Champion caitlyn = new Champion("Caitlyn", 1, "Enforcer", "", "Sniper", "", 500, 45, 5, 0.8, 15, 15, "Ace in the Hole", "Caitlyn takes aim at the farthest enemy, firing a deadly bullet towards them that deals magic damage to the first enemy it hits.", 0, 100);
//        Champion camille = new Champion("Camille", 1, "Clockwork", "", "Challenger", "", 700, 45, 1, 0.6, 40, 40, "Defensive Sweep", "Camille gains a shield blocking damage over 4 seconds, then sweeps her leg, dealing magic damage to enemies in a cone. While this shield holds, Camille's attacks restore Health.", 0, 60);
//        Champion chogath = new Champion("Cho'Gath", 3, "Mutant", "", "Bruiser", "Colossus", 750, 90, 1, 0.55, 50, 50, "Feast", "Cho’Gath devours the lowest Health enemy within range, dealing magic damage. If this kills the target, Cho’Gath gains a stack of Feast, up to max stacks. Each stack of Feast permanently grants 2% bonus Health and size.", 100, 165);
//        Champion corki = new Champion("Corki", 2, "Yordle", "", "Twinshot", "", 650, 55, 4, 0.7, 25, 25, "Bombardment", "Corki fires a missile at his target that explodes on impact, dealing magic damage to nearby enemies.", 25, 50);
//        Champion darius = new Champion("Darius", 1, "Syndicate", "", "Bodyguard", "", 650, 60, 1, 0.5, 40, 40, "Decimate", "Darius swings his axe in a circle, dealing magic damage, then heals himself Health for each enemy hit.", 70, 120);
//        Champion draven = new Champion("Draven", 4, "Debonair", "", "Challenger", "", 800, 75, 4, 0.8, 30, 30, "Spinning Axes", "Draven starts spinning an axe, empowering his next attack to deal % of his Attack Damage plus bonus physical damage. It will return to his original location after striking the target. If Draven catches it, he will empower the axe again. Draven can spin up to 2 axes at a time.", 0, 40);
//        Champion ekko = new Champion("Ekko", 3, "Scrap", "", "Assassin", "Innovator", 700, 55, 1, 0.7, 40, 40, "Parallel Convergence", "Ekko invokes an afterimage that bats a device towards the largest group of units. Upon landing, it deals magic damage to enemies within and applies reduced Attack Speed for 4 seconds. Allies inside gain Attack Speed for 4 seconds.", 60, 120);
//        Champion ezreal = new Champion("Ezreal", 1, "Scrap", "", "Innovator", "", 500, 45, 4, 0.65, 15, 15, "Mystic Shot", "Ezreal fires a missile at his target, dealing 150% of his Attack Damage plus bonus physical damage. If the missile hits, he grants himself 18% bonus stacking Attack Speed, up to 100% at 5 stacks.", 0, 40);
//        //test.getChampions().add(test);
//        ahri.getChampions().add(ahri);
//        alistar.getChampions().add(alistar);
//        ashe.getChampions().add(ashe);
//        blitzcrank.getChampions().add(blitzcrank);
//        brand.getChampions().add(brand);
//        braum.getChampions().add(braum);
//        caitlyn.getChampions().add(caitlyn);
//        camille.getChampions().add(camille);
//        chogath.getChampions().add(chogath);
//        corki.getChampions().add(corki);
//        darius.getChampions().add(darius);
//        draven.getChampions().add(draven);
//        ekko.getChampions().add(ekko);
//        ezreal.getChampions().add(ezreal);
//        //championRepository.save(test);
//        championRepository.save(ahri);
//        championRepository.save(alistar);
//        championRepository.save(ashe);
//        championRepository.save(blitzcrank);
//        championRepository.save(brand);
//        championRepository.save(braum);
//        championRepository.save(caitlyn);
//        championRepository.save(camille);
//        championRepository.save(chogath);
//        championRepository.save(corki);
//        championRepository.save(darius);
//        championRepository.save(draven);
//        championRepository.save(ekko);
//        championRepository.save(ezreal);

        System.out.println("Number of champions: " + championRepository.count());
    }

//    private String name;
//    private int cost;
//    private String origin;
//    private String className;
//    private int health;
//    private int ad;
//    private int atkRange;
//    private double atkSpeed;
//    private int armor;
//    private int mResist;
//    private String skillName;
//    private String skillText;
//    private int baseMana;
//    private int maxMana;
}
