package com.testservice.webapp.service;

import com.testservice.webapp.entity.User;
import com.testservice.webapp.repository.UserRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRep userRep;

    public UserServiceImpl(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRep.findAll();
    }

    @Override
    public User getById(int id) {
        return this.userRep.getById(id);
    }

    @Override
    public User getByUsername(String username) {
        return this.userRep.getByUsername(username);
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
