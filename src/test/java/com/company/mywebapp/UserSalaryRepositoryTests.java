package com.company.mywebapp;

import com.company.mywebapp.usersalary.UserSalary;
import com.company.mywebapp.usersalary.UserSalaryRepository;
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
public class UserSalaryRepositoryTests {
    @Autowired private UserSalaryRepository repos;

    @Test
    public void testAddNew(){
        UserSalary userSalary = new UserSalary();


        UserSalary savedUserSalary = repos.save(userSalary);
        Assertions.assertThat(savedUserSalary).isNotNull();
        Assertions.assertThat(savedUserSalary.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<UserSalary> usersalary = repos.findAll();
        Assertions.assertThat(usersalary).hasSizeGreaterThan(0);

        for(UserSalary userSalary : usersalary){
            System.out.println(usersalary);
        }
    }
    @Test
    public void testUpdate(){
        Integer usersalaryId = 1;
        Optional<UserSalary> optionalUserSalary = repos.findById(usersalaryId);
        UserSalary userSalary = optionalUserSalary.get();

        repos.save(userSalary);

        UserSalary updatedUserSalary = repos.findById(usersalaryId).get();

    }

    @Test
    public void testGet(){
        Integer usersalaryId = 1;
        Optional<UserSalary> optionalUserSalary = repos.findById(usersalaryId);
        Assertions.assertThat(optionalUserSalary).isPresent();
        System.out.println(optionalUserSalary.get());

    }

    @Test
    public void testDelete(){
        Integer usersalaryId = 1;
        repos.deleteById(usersalaryId);

        Optional<UserSalary> optionalUserSalary = repos.findById(usersalaryId);
        Assertions.assertThat(optionalUserSalary).isNotPresent();
    }
}
