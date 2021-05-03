package com.testservice.webapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "year_of_registration")
    private int yOfRegistration;

    public Vehicle(String type, String licencePlate, String model, String brand, int yOfRegistration) {
        this.type = type.toUpperCase();
        this.licencePlate = licencePlate.toUpperCase();
        this.model = model.toUpperCase();
        this.brand = brand.toUpperCase();
        this.yOfRegistration = yOfRegistration;
    }

    public Vehicle() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public int getyOfRegistration() {
        return yOfRegistration;
    }

    public void setyOfRegistration(int yOfRegistration) {
        this.yOfRegistration = yOfRegistration;
    }

}

/*
    @OneToMany(mappedBy = "theVehicle", cascade = CascadeType.REMOVE)
    private List<Reservation> reservation;

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
 */
