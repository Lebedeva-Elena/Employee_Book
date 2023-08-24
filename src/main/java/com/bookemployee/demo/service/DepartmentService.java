package com.bookemployee.demo.service;

import com.bookemployee.demo.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
@Service
public interface DepartmentService {
    Employee maxSalaryEmployee(int department);

    Employee minSalaryEmployee(int department);

    Collection<Employee> getEmployeeInDepartment(int department);

    Map<Integer, List<Employee>> getAll();
}
