package com.testservice.webapp.dto;

import com.testservice.webapp.entity.Reservation;

import java.util.Date;

public class Reserved {
    private int vehicleId;
    private Date startDate;
    private Date endDate;

    public Reserved(Reservation reservation) {
        this.vehicleId = reservation.getTheVehicle().getId();
        this.startDate = reservation.getStartDate();
        this.endDate = reservation.getEndDate();
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
}
