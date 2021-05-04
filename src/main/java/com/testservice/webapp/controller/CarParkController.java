package com.testservice.webapp.controller;

import com.testservice.webapp.entity.Reservation;
import com.testservice.webapp.entity.Vehicle;
import com.testservice.webapp.repository.ReservationRep;
import com.testservice.webapp.service.VehicleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jpa")
@CrossOrigin(origins = "http://localhost:4200")
public class CarParkController {

    private final VehicleService vehicleService;
    private final ReservationRep reservationRep;

    public CarParkController(VehicleService vehicleService, ReservationRep reservationRep) {
        this.vehicleService = vehicleService;
        this.reservationRep = reservationRep;
    }

    @GetMapping("/find")
    public Vehicle getVehicle() {
        return vehicleService.getVehicleById(1);
    }

    @GetMapping("/reservation")
    public Reservation getReservation() {
        return reservationRep.getReservationById(2);
    }

    @PostMapping("/add")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle, BindingResult bindingResult) {
        String ErrMsg = "";
        if (bindingResult.hasErrors()) {
            ErrMsg = "Error";
        }
        Vehicle checkVehicle = vehicleService.getVehicleById(vehicle.getId());

        if (checkVehicle != null) {
            ErrMsg = "Duplicate";
        }

        vehicleService.save(vehicle);
        if(ErrMsg.equals("")) {
            System.out.println(ErrMsg);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error");
        }
        Vehicle checkVehicle = vehicleService.getVehicleById(vehicle.getId());
        if(checkVehicle != null) {
            vehicleService.save(vehicle);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }
}
