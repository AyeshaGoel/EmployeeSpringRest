package com.cg.empmgt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cg.empmgt.exception.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleEmployeeNotFound(EmployeeNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidNameException.class)
	public String handleInvalidEmployeeName(InvalidNameException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidDeptException.class)
	public String handleInvalidDepartmentName(InvalidDeptException e) {
		return e.getMessage();
	}

}