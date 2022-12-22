package com.qcm.qcm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qcm.qcm.models.Qcm;
import com.qcm.qcm.models.Score;
import com.qcm.qcm.models.User;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
    Score findByQcm(Qcm qcm);
    Score findByQcmAndUser(Qcm qcm, User user);
}
