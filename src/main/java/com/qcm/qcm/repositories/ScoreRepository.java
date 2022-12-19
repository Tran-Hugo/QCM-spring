package com.qcm.qcm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qcm.qcm.models.Qcm;
import com.qcm.qcm.models.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
    Score findByQcm(Qcm qcm);
}
