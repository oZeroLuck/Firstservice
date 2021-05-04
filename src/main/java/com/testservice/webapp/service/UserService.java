package com.testservice.webapp.service;

import com.testservice.webapp.dto.UserDto;
import com.testservice.webapp.entity.User;

import java.util.List;

public interface UserService {

    User getById(int id);

    List<UserDto> getAllUsers();

    UserDto getDtoById(int id);

    User getByUsername(String username);

    User getByIdAndUsername(int id, String username);

    void create(User user);

    void update(User user);

    void deleteUser(User user);


}
