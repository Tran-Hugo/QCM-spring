package com.qcm.qcm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qcm.qcm.models.Qcm;
import com.qcm.qcm.models.Score;
import com.qcm.qcm.models.User;
import com.qcm.qcm.repositories.ScoreRepository;
import com.qcm.qcm.repositories.QcmRepository;
import com.qcm.qcm.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class ScoreController {
    @Autowired
    private ScoreRepository repository;
    @Autowired
    private QcmRepository qcmRepo;
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/Score/{id_qcm}")
    public Score show(@PathVariable String id_qcm){
        int qcmId = Integer.parseInt(id_qcm);
        Qcm qcm = qcmRepo.findById(qcmId).get();
        Score score = repository.findByQcm(qcm);
        
        return score;
    }

    @PostMapping("/score")
    public Score create(@RequestBody Map<String, String> body){
        Integer score = Integer.parseInt(body.get("score"));   
        Qcm qcm = qcmRepo.findById(Integer.parseInt(body.get("id_qcm"))).get();
        User user = userRepo.findById(Integer.parseInt(body.get("id_user"))).get();

        Score scoreObj = new Score();
        scoreObj.setScore(score);
        scoreObj.setQcm(qcm);
        scoreObj.setUser(user);
        return repository.save(scoreObj);
    }

}