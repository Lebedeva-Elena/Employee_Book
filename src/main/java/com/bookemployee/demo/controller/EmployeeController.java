package com.bookemployee.demo.controller;

import com.bookemployee.demo.dto.Employee;
import com.bookemployee.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remoteEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(String firstName, String lastName) {
        return employeeService.getEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> getAll() {
        return employeeService.findAll();
    }

}
