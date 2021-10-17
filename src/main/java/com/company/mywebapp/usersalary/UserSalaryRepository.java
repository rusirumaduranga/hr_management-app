package com.company.mywebapp.usersalary;

import org.springframework.data.repository.CrudRepository;

public interface UserSalaryRepository extends CrudRepository<UserSalary, Integer> {
    public Long countById(Integer id);
}
