package com.testservice.webapp.service;

import com.testservice.webapp.dto.ReservationDto;
import com.testservice.webapp.dto.Reserved;
import com.testservice.webapp.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<ReservationDto> getAllReservations();

    ReservationDto getDtoById(int id);

    Reservation getById(int id);

    List<ReservationDto> getByCustomerId(int id);

    List<Reserved> getReserved();

    void deleteReservation(Reservation reservation);

    void createReservation(Reservation reservation);

    void updateReservation(Reservation reservation);
}
