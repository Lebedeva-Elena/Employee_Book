package com.bookemployee.demo.service;

import com.bookemployee.demo.dto.Employee;
import com.bookemployee.demo.exception.EmployeeAlreadyAddedException;
import com.bookemployee.demo.exception.EmployeeNotFoundException;
import com.bookemployee.demo.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public  class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap;

    private static final int EMPLOYEES_SIZE = 3;

    public EmployeeServiceImpl() {

        this.employeeMap = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        if (employeeMap.size() == EMPLOYEES_SIZE) {
            throw new EmployeeStorageIsFullException();
        }

        String key = generateKey(firstName, lastName);

        if (employeeMap.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName,department,salary);
        employeeMap.put(key, employee);
        return employee;
    }

    @Override
    public Employee remoteEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        String key = generateKey(firstName, lastName);

        Employee employee = employeeMap.remove(key);

        if (Objects.isNull(employee)) {
            throw new EmployeeNotFoundException();

        }

        return employee;
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {

        String key = generateKey(firstName, lastName);

        Employee employee = employeeMap.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;

    }

    @Override
    public Collection<Employee> findAll() {

        return employeeMap.values();
    }

    private String generateKey(String firstName, String lastName) {
        return firstName + lastName;

    }
}
