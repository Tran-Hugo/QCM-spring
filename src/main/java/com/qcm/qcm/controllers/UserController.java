package com.qcm.qcm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qcm.qcm.models.User;
import com.qcm.qcm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/user")
    public List<User> index(){
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable String id){
        int UserId = Integer.parseInt(id);
        return repository.findById(UserId).get();
    }


}
