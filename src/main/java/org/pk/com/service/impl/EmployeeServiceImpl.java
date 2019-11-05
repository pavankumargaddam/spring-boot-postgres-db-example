package org.pk.com.service.impl;

import org.pk.com.domain.Employee;
import org.pk.com.exception.ResourceNotFoundException;
import org.pk.com.repository.EmployeeRepository;
import org.pk.com.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        LOG.debug("getAllEmployees method started");
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.size() > 0 ? employeeList : new ArrayList<>();
    }

    @Override
    public Employee getEmployeeById(Long id) throws ResourceNotFoundException {
        LOG.debug("getEmployeeById method started {}",id);
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee record exist for given id"));
    }

    @Override
    public Employee createOrUpdateEmployee(Employee employee) {
        LOG.debug("createOrUpdateEmployee method started {}",employee);
        Employee employeeRecord = employeeRepository.findById(employee.getId()).orElse(null);
        if (nonNull(employeeRecord)) {
            LOG.debug("update the record");
            employeeRecord.setEmail(employee.getEmail());
            employeeRecord.setFirstName(employee.getFirstName());
            employeeRecord.setLastName(employee.getLastName());
            return employeeRepository.save(employeeRecord);
        } else {
            LOG.debug("save the record");
            return employeeRepository.save(employee);
        }
    }

    @Override
    public void deleteEmployeeById(Long id) throws ResourceNotFoundException {
        LOG.debug("deleteEmployeeById method started {}",id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee record exist for given id"));
            employeeRepository.deleteById(employee.getId());
    }
}
