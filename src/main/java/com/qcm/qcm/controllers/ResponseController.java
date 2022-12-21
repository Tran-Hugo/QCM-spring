package com.qcm.qcm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qcm.qcm.models.Response;
import com.qcm.qcm.repositories.ResponseRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ResponseController {
    @Autowired
    private ResponseRepository repository;


    @GetMapping("/response/{id}")
    public Response show(@PathVariable String id){
        System.out.println("test");
        int responseId = Integer.parseInt(id);
        Response response = repository.findById(responseId).get();
        return response;
    }


}