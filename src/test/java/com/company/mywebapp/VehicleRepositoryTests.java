package com.company.mywebapp;

import com.company.mywebapp.vehicle.Vehicle;
import com.company.mywebapp.vehicle.VehicleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class VehicleRepositoryTests {
    @Autowired private VehicleRepository repov;

    @Test
    public void testAddNew(){
        Vehicle vehicle = new Vehicle();


        Vehicle savedVehicle = repov.save(vehicle);
        Assertions.assertThat(savedVehicle).isNotNull();
        Assertions.assertThat(savedVehicle.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<Vehicle> vehicles = repov.findAll();
        Assertions.assertThat(vehicles).hasSizeGreaterThan(0);

        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }
    @Test
    public void testUpdate(){
        Integer vehicleId = 1;
        Optional<Vehicle> optionalVehicle = repov.findById(vehicleId);
        Vehicle vehicle = optionalVehicle.get();

        repov.save(vehicle);

        Vehicle updatedVehicle = repov.findById(vehicleId).get();

    }

    @Test
    public void testGet(){
        Integer vehicleId = 1;
        Optional<Vehicle> optionalVehicle = repov.findById(vehicleId);
        Assertions.assertThat(optionalVehicle).isPresent();
        System.out.println(optionalVehicle.get());

    }

    @Test
    public void testDelete(){
        Integer userId = 1;
        repov.deleteById(userId);

        Optional<Vehicle> optionalVehicle = repov.findById(userId);
        Assertions.assertThat(optionalVehicle).isNotPresent();
    }
}
