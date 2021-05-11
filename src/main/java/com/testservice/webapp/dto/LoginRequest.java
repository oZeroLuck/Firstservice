package com.testservice.webapp.dto;

import com.testservice.webapp.entity.WebUser;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;

    public LoginRequest() {};

    public LoginRequest(WebUser webUser) {
        this.username = webUser.getUsername();
        this.password = webUser.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
