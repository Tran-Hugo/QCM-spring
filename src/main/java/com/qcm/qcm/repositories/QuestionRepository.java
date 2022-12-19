package com.qcm.qcm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qcm.qcm.models.Qcm;
import com.qcm.qcm.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
    List<Question> findByQcm(Qcm qcm);
}
