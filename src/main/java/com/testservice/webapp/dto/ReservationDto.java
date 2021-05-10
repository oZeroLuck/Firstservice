package com.testservice.webapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.testservice.webapp.entity.Reservation;

import java.util.Date;

public class ReservationDto {
    private int id;
    private int userId;
    private int vehicleId;
    private String vehiclePlate;
    private String vehicleBrand;
    private String vehicleModel;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;
    private String status;

    public ReservationDto(Reservation reservation) {
        this.id = reservation.getId();
        this.userId = reservation.getTheCustomer().getId();
        this.vehicleId = reservation.getTheVehicle().getId();
        this.vehiclePlate = reservation.getTheVehicle().getLicencePlate();
        this.vehicleBrand = reservation.getTheVehicle().getBrand();
        this.vehicleModel = reservation.getTheVehicle().getModel();
        this.startDate = reservation.getStartDate();
        this.endDate = reservation.getEndDate();
        this.status = reservation.getStatus().toLowerCase();
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

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
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
