package com.testservice.webapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.testservice.webapp.entity.WebUser;

import java.util.Date;

public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Rome")
    private Date birthDate;

    public UserDto(WebUser webUser) {
        this.id = webUser.getId();
        this.firstName = webUser.getFirstName();
        this.lastName = webUser.getLastName();
        this.email = webUser.getEmail();
        this.username = webUser.getUsername();
        this.birthDate = webUser.getBirthDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
