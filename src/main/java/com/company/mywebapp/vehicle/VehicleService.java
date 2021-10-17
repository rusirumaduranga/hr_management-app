package com.company.mywebapp.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired private VehicleRepository repov;

    public List<Vehicle> listAll(){
        return (List<Vehicle>) repov.findAll();
    }

    public void save(Vehicle vehicle) {
        repov.save(vehicle);
    }

    public Vehicle get(Integer id) throws VehicleNotFoundException {
        Optional<Vehicle> result = repov.findById(id);
        if (result.isPresent()){
        return result.get();
        }
        throw new VehicleNotFoundException("Could not find any vehicles with ID" + id);
    }

    public void delete(Integer id) throws VehicleNotFoundException {
        Long count = repov.countById(id);
        if (count == null || count == 0){
            throw new VehicleNotFoundException("Could not find any vehicles with ID " + id);
        }
        repov.deleteById(id);
    }

}
