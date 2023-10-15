package com.bookemployee.demo.service;

import com.bookemployee.demo.dto.Employee;
import com.bookemployee.demo.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private List<Employee> employees = List.of(
            new Employee("Artem", "Alekseev", 3, 40_000),
            new Employee("Lev", "Tihiy", 3, 20_000),
            new Employee("Egor", "Chernov", 4, 50_000));

    @Test
    void maxSalaryEmployee_shouldReturnEmployeeWithMaxSalaryWhenEmployeesInDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        Employee result = departmentService.maxSalaryEmployee(employees.get(0).getDepartment());

        assertEquals(employees.get(0), result);
    }

    @Test
    void maxSalaryEmployee_shouldThrowExceptionWhenNotEmployeeInDepartment() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.maxSalaryEmployee(2));
    }

    @Test
    void minSalaryEmployee_shouldReturnEmployeeWithMinSalaryWhenEmployeesInDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        Employee result = departmentService.minSalaryEmployee(employees.get(1).getDepartment());

        assertEquals(employees.get(1), result);
    }
    @Test
    void minSalaryEmployee_shouldThrowExceptionWhenNotEmployeeInDepartment() {
        when(employeeService.findAll()).thenReturn(Collections.emptyList());

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.minSalaryEmployee(2));
    }

    @Test
    void getEmployeeInDepartment_shouldReturnEmployeesWhenEmployeesInDepartment() {
        when(employeeService.findAll()).thenReturn(employees);

        Collection<Employee> result = departmentService.getEmployeesInDepartment(employees.get(0).getDepartment());

        assertEquals(List.of(employees.get(0), employees.get(1)), result);


    }

    @Test
    void getAll_shouldReturnMapWithEmployeeWhenEmployeeInDepartments() {
        when(employeeService.findAll()).thenReturn(employees);
        Map<Integer, List<Employee>> expectedMap = Map.of(
                3, List.of(employees.get(0), employees.get(1)),
                4, List.of(employees.get(2)));

        Map<Integer, List<Employee>> result = departmentService.getAll();

        assertEquals(expectedMap, result);
    }
}