package com.testservice.webapp.service;

import com.testservice.webapp.dto.AuthenticationInfoDto;
import com.testservice.webapp.entity.User;
import com.testservice.webapp.repository.UserRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRep userRep;

    public AuthenticationServiceImpl(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public AuthenticationInfoDto getUserInfo(String username) {
        User user = userRep.getByUsername(username);
        return new AuthenticationInfoDto(user);
    }
}
