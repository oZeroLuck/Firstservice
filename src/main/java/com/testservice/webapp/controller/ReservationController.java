package com.testservice.webapp.controller;

import com.testservice.webapp.dto.ReservationDto;
import com.testservice.webapp.dto.Reserved;
import com.testservice.webapp.service.ReservationService;
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
        return this.reservationService.getByCustomerId(customerId);
    }

    @GetMapping("/getReserved")
    public List<Reserved> getReserved() {
        return this.reservationService.getReserved();
    }
}
