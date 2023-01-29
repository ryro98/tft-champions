package com.project.tft.repository;

import com.project.tft.entity.Champion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChampionRepository extends CrudRepository<Champion, Integer> {
    @Transactional
    List<Champion> findByOrderByNameAsc();
}
