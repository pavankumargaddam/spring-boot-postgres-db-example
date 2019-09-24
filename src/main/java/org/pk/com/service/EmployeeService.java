package org.pk.com.service;

import org.pk.com.domain.Employee;
import org.pk.com.exception.RecordNotFoundException;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id) throws RecordNotFoundException;

    Employee createOrUpdateEmployee(Employee employee) throws RecordNotFoundException;

    void deleteEmployeeById(Long id) throws RecordNotFoundException;
}
