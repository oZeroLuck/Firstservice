package com.testservice.webapp.dto;

import javax.validation.constraints.NotNull;

public class ApproveRequest {
    @NotNull
    int id;
    @NotNull
    String status;

    public ApproveRequest () {};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
