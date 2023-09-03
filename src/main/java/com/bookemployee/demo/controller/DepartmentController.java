package com.bookemployee.demo.controller;

import com.bookemployee.demo.dto.Employee;
import com.bookemployee.demo.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAll() {
        return departmentService.getAll();

    }

    @GetMapping("/max-salary")
    public Employee maxSalaryEmployee(@RequestParam int departmentId) {
        return departmentService.maxSalaryEmployee(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryEmployee(@RequestParam int departmentId) {
        return departmentService.minSalaryEmployee(departmentId);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public Collection<Employee> getEmployeeInDepartment(@RequestParam int departmentId) {
        return departmentService.getEmployeeInDepartment(departmentId);

    }

}
