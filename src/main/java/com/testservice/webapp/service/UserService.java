package com.testservice.webapp.service;

import com.testservice.webapp.dto.UserDto;
import com.testservice.webapp.entity.WebUser;

import java.util.List;

public interface UserService {

    WebUser getById(int id);

    List<UserDto> getAllUsers();

    UserDto getDtoById(int id);

    WebUser getByUsername(String username);

    WebUser getByIdAndUsername(int id, String username);

    void create(WebUser webUser);

    void update(WebUser webUser);

    void deleteUser(WebUser webUser);


}
