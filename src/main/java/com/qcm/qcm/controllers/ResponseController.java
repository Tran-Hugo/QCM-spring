package com.qcm.qcm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qcm.qcm.models.Response;
import com.qcm.qcm.models.ResponsePOJO;
import com.qcm.qcm.repositories.ResponseRepository;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ResponseController {
    @Autowired
    private ResponseRepository repository;


    @GetMapping("/response/{id}")
    public ResponsePOJO show(@PathVariable String id){
        int responseId = Integer.parseInt(id);
        Response response = repository.findById(responseId).get();

        // HashMap<String, String> json = new HashMap<>();

        // json.put("id", Integer.toString(response.getId()));
        // json.put("contenct", response.getContent());
        // json.put("is_correct", Boolean.toString(response.getIs_correct()));
        ResponsePOJO pojo = new ResponsePOJO();
        pojo.setId(response.getId());
        pojo.setContent(response.getContent());
        pojo.setIs_correct(response.getIs_correct());
        return pojo;
    }


}