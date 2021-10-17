package com.company.mywebapp.department;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 45)
    private String departmentname;

    @Column(length = 45, nullable = false, name = "location")
    private String location;

    @Column(length = 45, nullable = false, name = "employee_count")
    private int employeecount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public int getEmployeecount() {
        return employeecount;
    }

    public void setEmployeecount(int employeecount) {
        this.employeecount = employeecount;
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentname='" + departmentname + '\'' +
                ", location='" + location + '\'' +
                ", employeecount='" + employeecount + '\'' +
                '}';
    }

}
