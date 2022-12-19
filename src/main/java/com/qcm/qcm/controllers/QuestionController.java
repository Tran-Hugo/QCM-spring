package com.qcm.qcm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qcm.qcm.models.Question;
import com.qcm.qcm.models.Response;
import com.qcm.qcm.repositories.QuestionRepository;
import com.qcm.qcm.repositories.ResponseRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class QuestionController {
    @Autowired
    private QuestionRepository repository;
    @Autowired
    private ResponseRepository ResponseRepo;


    @GetMapping("/question/{id}/reponses")
    public List<Response> show(@PathVariable String id){
        int questionId = Integer.parseInt(id);
        Question question = repository.findById(questionId).get();
        List<Response> Responses = ResponseRepo.findByQuestion(question);
        return Responses;
    }


}
