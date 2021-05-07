package com.testservice.webapp.service;

import com.testservice.webapp.entity.Vehicle;
import com.testservice.webapp.repository.VehicleRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRep vehicleRep;

    public VehicleServiceImpl(VehicleRep vehicleRep) {
        this.vehicleRep = vehicleRep;
    }

    @Override
    public List<Vehicle> getAll() {
        return this.vehicleRep.findAll();
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return this.vehicleRep.getVehicleById(id);
    }

    @Override
    @Transactional
    public void save(Vehicle vehicle) {
        this.vehicleRep.save(vehicle);
    }

    @Override
    @Transactional
    public void update(Vehicle vehicle) { this.vehicleRep.save(vehicle);}

    @Override
    @Transactional
    public void delete(Vehicle vehicle) {
        this.vehicleRep.delete(vehicle);
    }
}
