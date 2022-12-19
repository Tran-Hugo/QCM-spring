package com.qcm.qcm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qcm.qcm.models.Qcm;
import com.qcm.qcm.models.Question;
import com.qcm.qcm.repositories.QcmRepository;
import com.qcm.qcm.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class QcmController {
    @Autowired
    private QcmRepository repository;
    @Autowired
    private QuestionRepository questionRepo;

    @GetMapping("/qcm")
    public List<Qcm> index(){
        return repository.findAll();
    }

    @GetMapping("/qcm/{id}")
    public List<Question> show(@PathVariable String id){
        int qcmId = Integer.parseInt(id);
        Qcm qcm = repository.findById(qcmId).get();
        List<Question> questions = questionRepo.findByQcm(qcm);
        
        return questions;
    }


}
