package com.company.mywebapp;

import com.company.mywebapp.department.Department;
import com.company.mywebapp.department.DepartmentRepository;
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
public class DepartmentRepositoryTests {
    @Autowired private DepartmentRepository repom;

    @Test
    public void testAddNew(){
        Department department = new Department();
        department.setDepartmentname("HR");

        department.setLocation("1st floor");
        department.setEmployeecount(20);

        Department savedDepartment = repom.save(department);
        Assertions.assertThat(savedDepartment).isNotNull();
        Assertions.assertThat(savedDepartment.getId()).isGreaterThan(0);
    }


    @Test
    public void testUpdate(){
        Integer departmentId = 1;
        Optional<Department> optionalDepartment = repom.findById(departmentId);
        Department department = optionalDepartment.get();

        repom.save(department);

        Department updatedVehicle = repom.findById(departmentId).get();

    }

    @Test
    public void testGet(){
        Integer departmentId = 1;
        Optional<Department> optionalDepartment = repom.findById(departmentId);
        Assertions.assertThat(optionalDepartment).isPresent();
        System.out.println(optionalDepartment.get());

    }

    @Test
    public void testDelete(){
        Integer departmentId = 1;
        repom.deleteById(departmentId);

        Optional<Department> optionalDepartment = repom.findById(departmentId);
        Assertions.assertThat(optionalDepartment).isNotPresent();
    }
}
