package com.bookemployee.demo.service;

import com.bookemployee.demo.dto.Employee;
import com.bookemployee.demo.exception.EmployeeAlreadyAddedException;
import com.bookemployee.demo.exception.EmployeeNotFoundException;
import com.bookemployee.demo.exception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Collection;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private EmployeeServiceImpl underTest;

    @BeforeEach
    void beforeEach() {
        underTest = new EmployeeServiceImpl();
    }
    private Employee expectedEmployee = new Employee("Artem", "Alekseev",
            3,40_000);
    @Test
    void addEmployee_shouldAddEmployeeToMapAndReturnEmployee() {
        Employee result = underTest.addEmployee(expectedEmployee.getFirstName(),
                expectedEmployee.getLastName(), expectedEmployee.getDepartment(),
                expectedEmployee.getSalary());

        assertTrue(underTest.findAll().contains(expectedEmployee));
        assertEquals(expectedEmployee, result);
    }

    @Test
    void addEmployee_shouldThrowExceptionWhenNotEnoughMapSize() {
        for (int i = 0; i < 3; i++) {
            underTest.addEmployee((expectedEmployee.getFirstName() + i),
                    (expectedEmployee.getLastName() + i), expectedEmployee.getDepartment(),
                    expectedEmployee.getSalary());
        }
        assertThrows(EmployeeStorageIsFullException.class, () -> underTest.addEmployee(
                expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(), expectedEmployee.getSalary()));

    }

    @Test
    void addEmployee_shouldThrowExceptionWhenEqualEmployeeInMap() {
        underTest.addEmployee(expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(), expectedEmployee.getSalary());
        assertThrows(EmployeeAlreadyAddedException.class, () -> underTest.addEmployee(
                expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(), expectedEmployee.getSalary()));
    }

    @Test
    void removeEmployee_shouldAddEmployeeToMapAndRemoveEmployeeAndReturnEmployee() {
        underTest.addEmployee(expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
            expectedEmployee.getDepartment(), expectedEmployee.getSalary());
        Employee result = underTest.removeEmployee(expectedEmployee.getFirstName(),
                expectedEmployee.getLastName(), expectedEmployee.getDepartment(),
                expectedEmployee.getSalary());
        assertTrue(underTest.findAll().isEmpty());
        assertEquals(expectedEmployee, result);

    }

    @Test
    void removeEmployee_shouldThrowExceptionWhenRemoveEmployeeNotFoundInMap() {
        underTest.removeEmployee(expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                    expectedEmployee.getDepartment(), expectedEmployee.getSalary());

        assertThrows(EmployeeNotFoundException.class, () -> underTest.removeEmployee(
                expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(), expectedEmployee.getSalary()));


    }

    @Test
    void getEmployee_shouldGetEmployeeToMapAndReturnEmployee() {
        Employee result = underTest.getEmployee(expectedEmployee.getFirstName(), expectedEmployee.getLastName());

        assertTrue(underTest.findAll().contains(expectedEmployee));
        assertEquals(expectedEmployee, result);

    }

    @Test
    void getEmployee_shouldThrowExceptionWhenGetEmployeeNotFound() {

    }

    @Test
    void findAll_shouldReturnEmployeesListWhenEmployeeInMap() {
        Employee employee = new Employee("Anna", "Sidorova", 5,
                35_000);
        underTest.addEmployee(expectedEmployee.getFirstName(), expectedEmployee.getLastName(),
                expectedEmployee.getDepartment(), expectedEmployee.getSalary());
        underTest.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getDepartment(),
                employee.getSalary());

        Collection<Employee> result = underTest.findAll();

        assertTrue(result.containsAll(List.of(expectedEmployee, employee)));

    }

    @Test
    void findAll_shouldReturnEmptyListEmployeeNotInMap() {
        Collection<Employee> all = underTest.findAll();
        assertTrue(all.isEmpty());
    }
}