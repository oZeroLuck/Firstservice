package com.testservice.webapp.dto;

public class ApproveRequest {
    int id;
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