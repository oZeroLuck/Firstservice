package com.testservice.webapp.service;

import com.testservice.webapp.entity.Vehicle;

public interface VehicleService {
    public Vehicle getVehicleById(int id);

    public void createVehicle(Vehicle vehicle);

    public void deleteVehicle(Vehicle vehicle);
}
