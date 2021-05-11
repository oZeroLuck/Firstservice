package com.testservice.webapp.dto;

import javax.validation.constraints.NotNull;

public class PassRequest {
    @NotNull
    private int id;
    private String currentPassword;
    private String newPassword;

    public PassRequest() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
