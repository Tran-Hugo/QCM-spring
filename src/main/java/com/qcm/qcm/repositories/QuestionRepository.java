package com.qcm.qcm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qcm.qcm.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
}
