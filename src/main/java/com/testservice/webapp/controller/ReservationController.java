package com.testservice.webapp.controller;

import com.testservice.webapp.dto.ApproveRequest;
import com.testservice.webapp.dto.ResCURequest;
import com.testservice.webapp.dto.ReservationDto;
import com.testservice.webapp.dto.Reserved;
import com.testservice.webapp.entity.Reservation;
import com.testservice.webapp.entity.Vehicle;
import com.testservice.webapp.entity.WebUser;
import com.testservice.webapp.service.ReservationService;
import com.testservice.webapp.service.UserService;
import com.testservice.webapp.service.VehicleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin("http://localhost:4200")
public class ReservationController {

    private final ReservationService reservationService;
    private final UserService userService;
    private final VehicleService vehicleService;

    public ReservationController (ReservationService reservationService,
                                  UserService userService,
                                  VehicleService vehicleService) {
        this.reservationService = reservationService;
        this.userService = userService;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ReservationDto>> getAll() {
        List<ReservationDto> reservations = this.reservationService.getAllReservations();
        if (reservations != null && !reservations.isEmpty()) {
            return new ResponseEntity<>(reservations, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getById/{customerId}")
    public ResponseEntity<List<ReservationDto>> getByCustomer(@PathVariable("customerId") int customerId) {
        List<ReservationDto> reservationDtos = reservationService.getByCustomerId(customerId);
        if (reservationDtos != null && !reservationDtos.isEmpty()){
            return new ResponseEntity<>(reservationDtos, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getRes/{reservationId}")
    public ResponseEntity<ReservationDto> getResById(@PathVariable("reservationId") int resId) {
        ReservationDto reservationDto = reservationService.getDtoById(resId);
        if (reservationDto != null) {
            return new ResponseEntity<>(reservationDto, HttpStatus.OK
);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getReserved")
    public ResponseEntity<List<Reserved>> getReserved() {
        List<Reserved> reserved = this.reservationService.getReserved();
        if (reserved != null && !reserved.isEmpty()) {
            return new ResponseEntity<>(reserved, HttpStatus.OK
);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody ResCURequest request,
                                                         BindingResult bindingResult) {
        WebUser user = userService.getById(request.getUserId());
        Vehicle vehicle = vehicleService.getVehicleById(request.getVehicleId());
        if (user != null && vehicle != null && !bindingResult.hasErrors()) {
            Reservation newRes = new Reservation(vehicle,
                                                 request.getStartDate(),
                                                 request.getEndDate(),
                                                 user);
            reservationService.createReservation(newRes);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable int id) {
        Reservation checkRes = reservationService.getById(id);
        if (checkRes != null) {
            reservationService.deleteReservation(checkRes);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Reservation> updateReservation(@Valid @RequestBody ResCURequest request,
                                                         BindingResult bindingResult) {
        WebUser user = userService.getById(request.getUserId());
        Vehicle vehicle = vehicleService.getVehicleById(request.getVehicleId());
        Reservation reservation = reservationService.getById(request.getId());
        if (user != null && vehicle != null && reservation !=null && !bindingResult.hasErrors()) {
            reservationService.updateReservation(reservation);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/approve")
    public ResponseEntity<?> approveReservation(@Valid @RequestBody ApproveRequest request,
                                                BindingResult bindingResult) {
        Reservation reservation = reservationService.getById(request.getId());
        if (reservation != null && !bindingResult.hasErrors()) {
            reservation.setStatus(request.getStatus());
            reservationService.updateReservation(reservation);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }
}
