package com.cg.app.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.app.account.SavingsAccount;
import com.cg.app.account.service.SavingsAccountService;
import com.cg.app.exception.AccountNotFoundException;

@Controller
public class HomeController {

	@Autowired
	public SavingsAccountService service;

	@RequestMapping("/*")
	public String home() {
		return "index";
	}

	@RequestMapping("/AddNewAccount")
	public String createNewAccount() {
		return "AddNewAccount";
	}

	@RequestMapping("/OpenAccount")
	public String createAccount(@RequestParam("accountHolderName") String accountHolderName,
			@RequestParam("accountBal") double balance, @RequestParam("rdSalary") boolean salary)
			throws ClassNotFoundException, SQLException {

		SavingsAccount account = service.createNewAccount(accountHolderName, balance, salary);
		return "index";
	}

	@RequestMapping("/closeaccount")
	public String closeAccount() {
		return "CloseAccount";
	}

	@RequestMapping("/closeAccount")
	public String closeTheAccount(@RequestParam("accountNo") int accountNumber)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		service.deleteAccount(accountNumber);
		return "ClosedAccount";
	}

	@RequestMapping("/getcurrentbalance")
	public String getCurrentBalance() {
		return "GetCurrentBalance";
	}

	@RequestMapping("/getCurrentBalance")
	public String getTheCurrentBalance(@RequestParam("accountNo") int accountNumber, Model model)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = service.getCurrentBalance(accountNumber);
		model.addAttribute("account", account);
		return "CurrentBalance";
	}

	@RequestMapping("/withdraw")
	public String wtihDrawForm() {
		return "withdraw";
	}

	@RequestMapping("/WithdrawForm")
	public String withdrawAccountTask(@RequestParam("accountNo") int accountNumber,
			@RequestParam("amount") double amount, Model model)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = service.getAccountById(accountNumber);
		service.withdraw(account, amount);
		model.addAttribute("account", account);
		return "index";
	}

	@RequestMapping("/Account")
	public String UpdateAccountRedirect() {
		return "UpdateForm";

	}

	@RequestMapping("/updatedAccount")
	public String UpdateAccount(@RequestParam("accountNumber") int accountNumber, Model model)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = service.getAccountById(accountNumber);
		model.addAttribute("account", account);
		return "updatedform";
	}

	@RequestMapping("/updateAccount")
	public String UpdatedAccount(@RequestParam("accountHolderName") String accountHolderName,
			@RequestParam("rdSalary") boolean salary)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {

		SavingsAccount account = new SavingsAccount(accountHolderName, salary);

		account = service.updateAccount(account);

		return "index";
	}

	@RequestMapping("/getAllTheAccounts")
	public String getAllAccounts(@ModelAttribute("accounts"),Model model) throws ClassNotFoundException, SQLException {
		List<SavingsAccount> accounts = service.getAllSavingsAccount();
		model.addAllAttributes(accounts);
		return "GetAccounts";
	}

}
