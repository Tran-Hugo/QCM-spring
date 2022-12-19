package com.qcm.qcm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qcm.qcm.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    // custom query to search in contact
}
