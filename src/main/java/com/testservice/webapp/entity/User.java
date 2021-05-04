package com.testservice.webapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    @Size//(min=2, max=50, message="{Size.customer.validation}")
    private String firstName;

    @Column(name = "last_name")
    @Size//(min=2, max=50, message="{Size.customer.validation}")
    private String lastName;

    @Column(unique = true, name = "email")
    @Email//(message="{Size.customer.email.validation}")
    private String email;

    @Column(unique = true, name = "username")
    @Size//(min=2, max=50, message="{Size.customer.validation}")
    private String username;

    @Column(name = "password")
    @Size//(min=4, message="{Size.customer.password.validation}")
    private String password;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(mappedBy = "theCustomer", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Reservation> reservations;

    @Column(name = "is_admin")
    private boolean isAdmin;

    public User() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String username, String password, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.isAdmin = false;

    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
