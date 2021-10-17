package com.company.mywebapp.department;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    public Long countById(Integer id);
}
