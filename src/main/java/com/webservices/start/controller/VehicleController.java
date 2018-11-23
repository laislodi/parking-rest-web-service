package com.webservices.start.controller;

import com.webservices.start.persistence.model.Vehicle;
import com.webservices.start.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @ResponseStatus(HttpStatus.FOUND)
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Vehicle> findAllClients () {
        return vehicleService.findAllVehicles();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Vehicle findVehicle(@RequestParam Long id) {
        return vehicleService.findVehicle(id);
    }

    @RequestMapping(value = "/edit/", method = RequestMethod.PUT)
    public void editVehicle (@RequestBody Vehicle vehicle) {
        vehicleService.editVehicle(vehicle);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public void newVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
    }
}
