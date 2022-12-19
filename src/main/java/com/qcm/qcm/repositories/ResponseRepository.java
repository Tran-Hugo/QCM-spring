package com.qcm.qcm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qcm.qcm.models.Question;
import com.qcm.qcm.models.Response;

public interface ResponseRepository extends JpaRepository<Response, Integer>{
    List<Response> findByQuestion(Question question);
}
