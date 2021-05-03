package com.testservice.webapp.service;

import com.testservice.webapp.dto.ReservationDto;
import com.testservice.webapp.entity.Reservation;

import java.util.List;

public interface ReservationService {
    public List<ReservationDto> getAllReservations();

    public ReservationDto getById(int id);

    public List<ReservationDto> getByCustomerId(int id);

    public void deleteReservation(Reservation reservation);

    public void createReservation(Reservation reservation);
}
