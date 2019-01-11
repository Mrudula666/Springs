package com.cg.app.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cg.app.employee.dao.EmployeeDao;
import com.cg.app.employee.pojo.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void addNewEmployee(Employee employee) {
		
		employeeDao.addNewEmployee(employee);
	}

}
