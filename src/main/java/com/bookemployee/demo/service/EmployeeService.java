package com.bookemployee.demo.service;

import com.bookemployee.demo.dto.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee addEmployee(String firstName, String lastName, int department, double salary);

    Employee remoteEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName, int department, double salary);

    Employee getEmployee(String firstName, String lastName);

    Collection<Employee> findAll();
}

