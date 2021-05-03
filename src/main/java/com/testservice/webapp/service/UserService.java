package com.testservice.webapp.service;

import com.testservice.webapp.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getById(int id);

    public User getByUsername(String username);

    public void saveUser(User user);

    public void deleteUser(User user);
}
