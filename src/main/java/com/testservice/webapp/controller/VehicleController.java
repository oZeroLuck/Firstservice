package com.testservice.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.testservice.webapp.entity.Vehicle;
import com.testservice.webapp.service.VehicleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/get/{id}")
    public Vehicle getVehicle(@PathVariable("id") int id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping("/get/all")
    public List<Vehicle> getAll() {
        System.out.println("getting");
        List<Vehicle> vehicles = vehicleService.getAll();
        System.out.println(vehicles.get(0));
        return vehicles;
    }

    @PostMapping("/create")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle, BindingResult bindingResult) {
        String ErrMsg = "";
        if (bindingResult.hasErrors()) {
            ErrMsg = "Error";
        }
        Vehicle checkVehicle = vehicleService.getVehicleById(vehicle.getId());

        if (checkVehicle != null) {
            ErrMsg = "Duplicate";
        }

        vehicleService.save(vehicle);
        if(ErrMsg.equals("")) {
            System.out.println(ErrMsg);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error");
        }
        Vehicle checkVehicle = vehicleService.getVehicleById(vehicle.getId());
        if(checkVehicle != null) {
            vehicleService.save(vehicle);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle == null) {
            System.out.println("Error");
        }

        vehicleService.delete(vehicle);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode responseNode = mapper.createObjectNode();

        responseNode.put("code", HttpStatus.OK.toString());
        responseNode.put("message", "Delete vehicle " + id + " successfully executed");

        return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
    }
}
