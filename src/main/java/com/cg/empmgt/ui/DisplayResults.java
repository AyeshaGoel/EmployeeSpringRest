package com.cg.empmgt.ui;

import com.cg.empmgt.beans.Employee;
import com.cg.empmgt.exception.*;
import com.cg.empmgt.service.*;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisplayResults {
	
	@Autowired
	private IEmployeeService service ;

/*
	public static void main(String[] args) {
		DisplayResults app = new DisplayResults();
		app.start();
	}
	*/

	public void start() {
		try {
			Employee ayesha = service.add("Ayesha", "CSE");			

			Employee miloni = service.add("Miloni", "Mechanical");	

			Employee rachna = service.add("Rachna", "EXTC");
			
			//display(ayesha);
			//display(miloni);
			//display(rachna);

			List<Employee> list = service.findAll();
			displayAll(list);
		} catch (InvalidIdException e) {
			System.out.println(e.getMessage());

		} catch (InvalidDeptException e) {
			System.out.println(e.getMessage());

		} catch (InvalidNameException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {
			System.out.println("something went wrong");

		}

	}

	public void displayAll(Collection<Employee> employees) {
		for (Employee employee : employees) {
			display(employee);
		}
	}

	public void display(Employee employee) {
		System.out.println(employee.getId() + "-" + employee.getName() + "-" + "-" + employee.getDepartment());
	

}}
