package com.company.mywebapp.usersalary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSalaryService {
    @Autowired private UserSalaryRepository repos;

    public List<UserSalary> listAll(){
        return (List<UserSalary>) repos.findAll();
    }

    public void save(UserSalary userSalary) {
        repos.save(userSalary);
    }

    public UserSalary get(Integer id) throws UserSalaryNotFoundException {
        Optional<UserSalary> result = repos.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserSalaryNotFoundException("Could not find any users salary with ID" + id);
    }

    public void delete(Integer id) throws UserSalaryNotFoundException {
        Long count = repos.countById(id);
        if (count == null || count == 0){
            throw new UserSalaryNotFoundException("Could not find any users salary with ID " + id);
        }
        repos.deleteById(id);
    }

}
