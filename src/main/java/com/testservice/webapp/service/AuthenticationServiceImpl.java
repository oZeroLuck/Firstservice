package com.testservice.webapp.service;

import com.testservice.webapp.dto.AuthenticationInfoDto;
import com.testservice.webapp.entity.WebUser;
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
        WebUser webUser = userRep.getByUsername(username);
        System.out.println(webUser.getPassword());
        return new AuthenticationInfoDto(webUser);
    }
}
