package com.testservice.webapp.dto;

import com.testservice.webapp.entity.Reservation;

import java.util.Date;

public class ReservationDto {
    private int id;
    private int userId;
    private int vehicleId;
    private Date startDate;
    private Date endDate;
    private String status;

    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        this.userId = reservation.getTheCustomer().getUserId();
        this.vehicleId = reservation.getTheVehicle().getId();
        this.startDate = reservation.getStartDate();
        this.endDate = reservation.getEndDate();
        this.status = reservation.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
