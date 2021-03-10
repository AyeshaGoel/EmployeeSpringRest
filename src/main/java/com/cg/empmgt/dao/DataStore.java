package com.cg.empmgt.dao;

import java.util.*;
import org.springframework.stereotype.Component;
import com.cg.empmgt.beans.Employee;

@Component
public class DataStore {
	
	public DataStore() {
		
	}
		
	private Map<Integer,Employee>store = new HashMap<>();
	
	public Map<Integer,Employee> getStore() {
        return store;
    }
	
	
}