package com.cg.app.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.app.account.SavingsAccount;
import com.cg.app.account.service.SavingsAccountService;

@Controller
public class HomeController {

	
	  @Autowired
	  public SavingsAccountService service;
	 

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	@RequestMapping("/AddNewAccount")
	public String createNewAccount() {
		return "AddNewAccount";
	}
	@RequestMapping("/OpenAccount")
	public String createAccount(@RequestParam("accountHolderName") String accountHolderName,
			@RequestParam("accountBal") double balance,
			@RequestParam("rdSalary") boolean salary) throws ClassNotFoundException, SQLException {
		System.out.println("Hii");
		SavingsAccount account = service.createNewAccount(accountHolderName, balance, salary);
		return "index";
	}
	
}
