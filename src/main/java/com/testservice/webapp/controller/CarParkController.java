package com.testservice.webapp.controller;

import com.testservice.webapp.entity.Reservation;
import com.testservice.webapp.entity.Vehicle;
import com.testservice.webapp.repository.ReservationRep;
import com.testservice.webapp.repository.VehicleRep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/jpa")
@CrossOrigin(origins = "http://localhost:4200")
public class CarParkController {

    private final VehicleRep vehicleRep;
    private final ReservationRep reservationRep;

    public CarParkController(VehicleRep vehicleRep, ReservationRep reservationRep) {
        this.vehicleRep = vehicleRep;
        this.reservationRep = reservationRep;
    }

    @GetMapping("/find")
    public Vehicle getVehicle() {
        return vehicleRep.getVehicleById(1);
    }

    @GetMapping("/reservation")
    public Reservation getReservation() {
        return reservationRep.getReservationById(2);
    }

    /*public ResponseEntity<Vehicle> createVehicle(@Valid @ResponseBody Vehicle vehicle) {

    }*/
}
