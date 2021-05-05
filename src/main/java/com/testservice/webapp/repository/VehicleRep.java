package com.testservice.webapp.repository;

import com.testservice.webapp.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRep extends CrudRepository<Vehicle, Integer> {

    List<Vehicle> findAll();

    Vehicle getVehicleById(Integer id);
}
