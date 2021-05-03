package com.testservice.webapp.repository;

import com.testservice.webapp.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRep extends CrudRepository<User, Integer> {

    List<User> findAll();

    User getById(int id);

    User getByUsername(String username);
}
