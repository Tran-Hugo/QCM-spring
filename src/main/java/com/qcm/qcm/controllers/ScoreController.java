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

    @PostMapping("/getScore")
    public Score get(@RequestBody Map<String, String> body){
        Qcm qcm = qcmRepo.findById(Integer.parseInt(body.get("id_qcm"))).get();
        User user = userRepo.findById(Integer.parseInt(body.get("id_user"))).get();

        Score score = repository.findByQcmAndUser(qcm, user);
        // System.out.println(score);
        // int qcmId = Integer.parseInt(id_qcm);
        // Qcm qcm = qcmRepo.findById(qcmId).get();
        // Score score = repository.findByQcm(qcm);
        
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
        // scoreObj = repository.save(scoreObj);
        // if (scoreObj.getId() == 0) {
        //     return false;
        // } else {
        //     return true;
        // }
        return  repository.save(scoreObj);
    }

    @PutMapping("/score")
    public Score update(@RequestBody Map<String, String> body){
        Integer scoreId = Integer.parseInt(body.get("id"));   
        Integer newScore = Integer.parseInt(body.get("score"));   

        Score score = repository.findById(scoreId).get();

        score.setScore(newScore);
        repository.save(score);

        return  score;
    }

}