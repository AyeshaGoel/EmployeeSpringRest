package com.cg.empmgt.service;

import com.cg.empmgt.beans.Employee;
import java.util.List;

public interface IEmployeeService {
	
	Employee add(String name, String department);
	
	Employee updateName(int id, String name);
	
	Employee findById(int id);
	
	void removeById(int id);
	
	List<Employee> findAll();
}
