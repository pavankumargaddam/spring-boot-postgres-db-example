package org.pk.com.service;

import org.pk.com.domain.Employee;
import org.pk.com.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id) throws ResourceNotFoundException;

    Employee createOrUpdateEmployee(Employee employee) throws ResourceNotFoundException;

    void deleteEmployeeById(Long id) throws ResourceNotFoundException;
}
