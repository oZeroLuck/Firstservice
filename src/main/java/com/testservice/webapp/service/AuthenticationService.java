package com.testservice.webapp.service;

import com.testservice.webapp.dto.LoginRequest;

public interface AuthenticationService {
    LoginRequest getUserInfo(String username);
}
