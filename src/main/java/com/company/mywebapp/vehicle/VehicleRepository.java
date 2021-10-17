package com.company.mywebapp.vehicle;

import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    public Long countById(Integer id);
}
