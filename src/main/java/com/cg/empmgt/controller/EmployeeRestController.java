package com.cg.empmgt.controller;


import java.util.List;
import com.cg.empmgt.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.empmgt.beans.Employee;
import com.cg.empmgt.service.*;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;

	
	@GetMapping("/byid/{id}")
    public Employee fetchEmployee(@PathVariable("id") int empId)
    {
        Employee employee = service.findById(empId);
        return employee;
    }

    @GetMapping
    public List<Employee> allEmployees()
    {
        List<Employee> list = service.findAll();
        return list;
    }
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
    public String addEmployee(@RequestBody CreateEmployeeRequest requestData) {
        Employee create = service.add(requestData.getName(), requestData.getDepartment());
        return "Created employee with id=" + create.getId();
    }
	
	@PutMapping("/changename")
    public Employee changeName(@RequestBody ChangeNameRequest changeNameRequest)
    {
        Employee employee = service.updateName(changeNameRequest.getId(),changeNameRequest.getName());
        return employee;
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody DeleteEmployeeRequest requestData){
        service.removeById(requestData.getId());
        return "Employee deleted for id="+requestData.getId();
    }
	
	

}