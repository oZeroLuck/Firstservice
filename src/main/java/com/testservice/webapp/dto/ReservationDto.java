package com.testservice.webapp.dto;

import com.testservice.webapp.entity.Reservation;

import java.util.Date;

public class ReservationDto {
    private int id;
    private int userId;
    private int vehicleId;
    private String vehicleInfo;
    private Date startDate;
    private Date endDate;
    private String status;

    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        this.userId = reservation.getTheCustomer().getId();
        this.vehicleId = reservation.getTheVehicle().getId();
        this.vehicleInfo = reservation.getTheVehicle().getBrand()
                                + " " + reservation.getTheVehicle().getModel();
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

    public String getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(String vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
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

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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
