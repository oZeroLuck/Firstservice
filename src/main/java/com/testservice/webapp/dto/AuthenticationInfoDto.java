package com.testservice.webapp.dto;

import com.testservice.webapp.entity.User;

public class AuthenticationInfoDto {

    private int id;
    private String username;
    private String password;
    private boolean isAdmin;

    public AuthenticationInfoDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.isAdmin = user.getIsAdmin();
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
