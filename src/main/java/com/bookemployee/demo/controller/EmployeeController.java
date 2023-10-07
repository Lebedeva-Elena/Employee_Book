package com.bookemployee.demo.controller;

import com.bookemployee.demo.dto.Employee;
import com.bookemployee.demo.service.EmployeeService;
import com.bookemployee.demo.util.EmployeeNameValidator;
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
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam int department, @RequestParam double salary) {
        EmployeeNameValidator.validateIsAlpha(firstName, lastName);
        return employeeService.addEmployee(firstName, lastName, department, salary);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        EmployeeNameValidator.validateIsAlpha(firstName, lastName);
        return employeeService.remoteEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(String firstName, String lastName) {
        EmployeeNameValidator.validateIsAlpha(firstName, lastName);
        return employeeService.getEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> getAll() {
        return employeeService.findAll();
    }

}
