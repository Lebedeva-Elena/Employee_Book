package com.bookemployee.demo.service;

import com.bookemployee.demo.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;

    private static final int EMPLOYEES_SIZE = 3;

    public EmployeeServiceImpl() {
        List<Employee> employees = new ArrayList<>();
    }

    public void addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
    }

    public void remoteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employees.remove(employee);
    }

}
