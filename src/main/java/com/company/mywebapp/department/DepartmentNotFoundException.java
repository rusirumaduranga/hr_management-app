package com.company.mywebapp.department;

public class DepartmentNotFoundException extends Throwable {
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
