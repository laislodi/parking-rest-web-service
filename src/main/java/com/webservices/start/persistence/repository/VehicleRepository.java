package com.webservices.start.persistence.repository;

import com.webservices.start.persistence.model.Vehicle;

import java.util.List;

public interface VehicleRepository {

    List<Vehicle> findAll();

    Vehicle findById(Long idVehicle);

    void save(Vehicle vehicle);
}
