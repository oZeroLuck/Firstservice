package com.testservice.webapp.repository;

import com.testservice.webapp.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRep extends CrudRepository<Vehicle, Integer> {

    Vehicle getVehicleById(Integer id);
}
