package com.bookemployee.demo.service;

import com.bookemployee.demo.dto.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee remoteEmployee(String firstName, String lastName);

    Employee getEmployee(String firstName, String lastName);

    Collection<Employee> findAll();
}

