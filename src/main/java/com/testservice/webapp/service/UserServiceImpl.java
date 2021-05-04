package com.testservice.webapp.service;

import com.testservice.webapp.dto.UserDto;
import com.testservice.webapp.entity.User;
import com.testservice.webapp.repository.UserRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRep userRep;

    public UserServiceImpl(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public User getById(int id) {
        return this.userRep.getById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRep.getDistinctByIsAdmin(false);
        List<UserDto> dtos = new ArrayList<>();
        for (User u: users) {
            UserDto temp = new UserDto(u);
            dtos.add(temp);
        }
        return dtos;
    }

    @Override
    public UserDto getDtoById(int id) {
        return new UserDto(this.userRep.getById(id));
    }

    @Override
    public User getByUsername(String username) {
        User user = this.userRep.getByUsername(username);
        return this.userRep.getByUsername(username);
    }

    @Override
    public User getByIdAndUsername(int id, String username) {
        return this.userRep.getByIdAndUsername(id, username);
    }

    @Override
    public void create(User user) {
        user.setIsAdmin(false);
        this.userRep.save(user);
    }

    @Override
    public void update(User user) {
        User temp = userRep.getById(user.getId());
        user.setPassword(temp.getPassword());
        this.userRep.save(user);
    }

    @Override
    public void deleteUser(User user) {
        this.userRep.delete(user);
    }
}
