package com.testservice.webapp.service;

import com.testservice.webapp.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getAll();

    Vehicle getVehicleById(int id);

    void save(Vehicle vehicle);

    void update(Vehicle vehicle);

    void delete(Vehicle vehicle);
}
