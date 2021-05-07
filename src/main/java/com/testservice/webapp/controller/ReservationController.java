package com.testservice.webapp.controller;

import com.testservice.webapp.dto.ReservationDto;
import com.testservice.webapp.dto.Reserved;
import com.testservice.webapp.entity.Reservation;
import com.testservice.webapp.service.ReservationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin("http://localhost:4200")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController (ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getAll")
    public List<ReservationDto> getAll() {
        return this.reservationService.getAllReservations();
    }

    @GetMapping("/getById/{customerId}")
    public List<ReservationDto> getAll(@PathVariable("customerId") int customerId) {
        return reservationService.getByCustomerId(customerId);
    }

    @GetMapping("/getReserved")
    public List<Reserved> getReserved() {
        return this.reservationService.getReserved();
    }

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation, BindingResult bindingResult) {
        reservationService.createReservation(reservation);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable int id) {
        Reservation checkRes = reservationService.getById(id);
        if (checkRes != null) {
            reservationService.deleteReservation(checkRes);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
}
