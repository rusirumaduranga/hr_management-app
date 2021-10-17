package com.company.mywebapp.usersalary;

import javax.persistence.*;

@Entity
@Table(name = "usersalary")
public class UserSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 45)
    private String employeename;

    @Column(length = 45, nullable = false, name = "job_role")
    private String jobrole;

    @Column(length = 45, nullable = false, name = "salary")
    private String salary;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getJobrole() {
        return jobrole;
    }

    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserSalary{" +
                "id=" + id +
                ", employeename='" + employeename + '\'' +
                ", jobrole='" + jobrole + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

}
