package com.testservice.webapp.service;

import com.testservice.webapp.dto.AuthenticationInfoDto;

public interface AuthenticationService {
    AuthenticationInfoDto getUserInfo(String username);
}
