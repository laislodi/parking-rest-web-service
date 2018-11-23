package com.webservices.start.persistence.repository;

import com.webservices.start.persistence.model.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Vehicle> findAll() {
        Query query = entityManager.createQuery("SELECT V FROM Vehicle V");
        return query.getResultList();
    }

    @Override
    public Vehicle findById(Long idVehicle) {
        return this.entityManager.find(Vehicle.class, idVehicle);
    }

    @Override
    @Transactional
    public void save(Vehicle vehicle) {
        entityManager.merge(vehicle);

    }
}
