package com.testservice.webapp.dto;

import com.testservice.webapp.entity.WebUser;

public class AuthenticationInfoDto {

    private int id;
    private String username;
    private String password;
    private boolean isAdmin;

    public AuthenticationInfoDto(WebUser webUser) {
        this.id = webUser.getId();
        this.username = webUser.getUsername();
        this.password = webUser.getPassword();
        this.isAdmin = webUser.getIsAdmin();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setIsAdmin(boolean hello) {this.isAdmin = hello;}

    public boolean getIsAdmin() {return this.isAdmin;}
}
