package com.webservices.start.service;

import com.webservices.start.persistence.model.Client;
import com.webservices.start.persistence.model.Vehicle;
import com.webservices.start.persistence.repository.ClientRepository;
import com.webservices.start.persistence.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle findVehicle (Long idVehicle) {
        return vehicleRepository.findById(idVehicle);
    }

    public void editVehicle (Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public void createVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
