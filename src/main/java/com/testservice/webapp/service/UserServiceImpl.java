package com.testservice.webapp.service;

import com.testservice.webapp.dto.UserDto;
import com.testservice.webapp.entity.WebUser;
import com.testservice.webapp.repository.UserRep;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRep userRep;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRep userRep, BCryptPasswordEncoder encoder) {
        this.userRep = userRep;
        this.encoder = encoder;
    }

    @Override
    public WebUser getById(int id) {
        return this.userRep.getById(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<WebUser> webUsers = this.userRep.getDistinctByIsAdmin(false);
        List<UserDto> dtos = new ArrayList<>();
        for (WebUser u: webUsers) {
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
    public WebUser getByUsername(String username) {
        return this.userRep.getByUsername(username);
    }

    @Override
    public WebUser getByIdAndUsername(int id, String username) {
        return this.userRep.getByIdAndUsername(id, username);
    }

    @Override
    @Transactional
    public void create(WebUser webUser) {
        webUser.setPassword(encoder.encode(webUser.getPassword()));
        this.userRep.save(webUser);
    }

    @Override
    @Transactional
    public void update(WebUser webUser) {
        WebUser temp = userRep.getById(webUser.getId());
        webUser.setPassword(temp.getPassword());
        this.userRep.save(webUser);
    }

    @Override
    @Transactional
    public void deleteUser(WebUser webUser) {
        this.userRep.delete(webUser);
    }

    @Override
    public boolean existByUsername(String username) {
        return userRep.existsWebUserByUsername(username);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRep.existsWebUserByEmail(email);
    }
}
