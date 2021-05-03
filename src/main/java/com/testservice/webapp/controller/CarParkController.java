package com.testservice.webapp.controller;

import com.testservice.webapp.entity.Vehicle;
import com.testservice.webapp.repository.VehicleRep;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jpa")
@CrossOrigin(origins = "http://localhost:4200")
public class CarParkController {

    private final VehicleRep vehicleRep;

    public CarParkController(VehicleRep vehicleRep) {
        this.vehicleRep = vehicleRep;
    }

    @GetMapping("/find")
    public Vehicle getVehicle() {
        return vehicleRep.getVehicleById(1);
    }
}
