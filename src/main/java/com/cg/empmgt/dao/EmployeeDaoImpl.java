package com.cg.empmgt.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.cg.empmgt.beans.Employee;
import com.cg.empmgt.exception.EmployeeNotFoundException;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{
	
	@Autowired
	private DataStore dataStore;	

	private Map<Integer, Employee> store;


	@PostConstruct
	public void afterInit(){
		store=dataStore.getStore();
	}
	
	public int generateId() {
    	int generatedId=store.size()+1;
	    return generatedId;
	}

	
	@Override
	public void add(Employee employee) {
		int id = generateId();
		employee.setId(id);
		store.put(id, employee);
		
	}
	
	@Override
	public Employee update(Employee employee) {
		store.put(employee.getId(), employee);
		return employee;
	}
	
	@Override
	public Employee findById(int id) {
		if(!store.containsKey(id)) {
			throw new EmployeeNotFoundException("Employee with id "+id+" doesn't exist");
		}
		Employee employee = store.get(id);
		return employee;
	}
	
	@Override
	public void removeById(int id) {
		store.remove(id);
	}
	
	@Override
	public List<Employee> findAll(){
		Collection<Employee> employees = store.values();
		List<Employee> list = new ArrayList<>(employees);
		return list;
	}

}