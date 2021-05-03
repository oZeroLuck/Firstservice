package com.testservice.webapp.repository;

import com.testservice.webapp.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRep extends CrudRepository<Reservation, Integer> {

    List<Reservation> findAll();

    List<Reservation> getByTheCustomerId(Integer id);

    Reservation getReservationById(Integer id);
}
