package com.testservice.webapp.controller;

import com.testservice.webapp.dto.ReservationDto;
import com.testservice.webapp.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "http://localhost:4200")
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
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ReservationDto> getAll(@PathVariable("customerId") int customerId) {
        return this.reservationService.getByCustomerId(customerId);
    }
}
