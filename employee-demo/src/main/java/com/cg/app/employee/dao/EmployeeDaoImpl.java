package com.cg.app.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.app.employee.pojo.Employee;
import com.cg.app.employee.service.EmployeeService;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EmployeeService service;

	@Override
	public void addNewEmployee(Employee employee) {
		
		
	}

}
