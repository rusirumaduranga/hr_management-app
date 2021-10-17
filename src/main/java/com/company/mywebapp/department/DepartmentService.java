package com.company.mywebapp.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired private DepartmentRepository repom;

    public List<Department> listAll(){
        return (List<Department>) repom.findAll();
    }

    public void save(Department vehicle) {
        repom.save(vehicle);
    }

    public Department get(Integer id) throws DepartmentNotFoundException {
        Optional<Department> result = repom.findById(id);
        if (result.isPresent()){
        return result.get();
        }
        throw new DepartmentNotFoundException("Could not find any vehicles with ID" + id);
    }

    public void delete(Integer id) throws DepartmentNotFoundException {
        Long count = repom.countById(id);
        if (count == null || count == 0){
            throw new DepartmentNotFoundException("Could not find any vehicles with ID " + id);
        }
        repom.deleteById(id);
    }

}
