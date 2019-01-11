package com.cg.app.employee.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.cg.app.employee.pojo.Employee;
import com.cg.app.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
		@RequestMapping(value="/save",method = RequestMethod.GET)
		public String askDetails(Map map) {
			map.put("employee", new Employee());
			return "input";
		}
	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * displayDetails(@ModelAttribute("employee") Employee employee) { return
	 * "display"; }
	 */

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("employee") Employee employee, BindingResult result,HttpServletRequest request) {
		if (result.hasErrors()) {
			return "input";
		}
		
		service.addNewEmployee(employee);
		HttpSession session = request.getSession();
		session.setAttribute("employee", employee);
		return "redirect: afterSave";
	}
	
	@RequestMapping(value = "/afterSave", method = RequestMethod.POST)
	public String save(SessionStatus status) {
		status.setComplete();
		return "display";
	}
	

}
