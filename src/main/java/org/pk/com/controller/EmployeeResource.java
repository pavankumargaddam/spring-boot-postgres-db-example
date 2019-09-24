package org.pk.com.controller;


import org.pk.com.domain.Employee;
import org.pk.com.exception.ResourceNotFoundException;
import org.pk.com.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeResource.class);

    @Autowired
    EmployeeService service;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() throws ResourceNotFoundException {
        LOG.debug("getAllEmployees method started");
        List<Employee> list = service.getAllEmployees();
        if(list.size()<=0){
            throw new ResourceNotFoundException("Employees are not found");
        }
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        LOG.debug("getEmployeeById method started {}",id);
        Employee entity;
        try{
            entity = service.getEmployeeById(id);
        }catch (ResourceNotFoundException e){
            throw e;
        }
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createOrUpdateEmployee(@Valid @RequestBody Employee employee) throws ResourceNotFoundException {
        LOG.debug("createOrUpdateEmployee method started {}",employee);
        Employee updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        LOG.debug("deleteEmployeeById method started {}",id);
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }

}
