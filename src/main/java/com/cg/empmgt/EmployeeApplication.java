package com.cg.empmgt;

import com.cg.empmgt.ui.DisplayResults;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args){
       ConfigurableApplicationContext context= SpringApplication.run(EmployeeApplication.class, args);
       DisplayResults employeeUI=context.getBean(DisplayResults.class);
       employeeUI.start();

    }

}