package com.cg.app.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.app.account.SavingsAccount;
import com.cg.app.account.SortByAccountBalance;
import com.cg.app.account.SortByAccountBalanceInDescending;
import com.cg.app.account.SortByAccountHolderName;
import com.cg.app.account.SortByAccountHolderNameInDescending;
import com.cg.app.account.service.SavingsAccountService;
import com.cg.app.exception.AccountNotFoundException;

@Controller
public class HomeController {

	@Autowired
	public SavingsAccountService service;
	
	@Autowired
	public List<SavingsAccount> accounts;
	boolean flag = true;

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
		return "GetAccounts";
	}
	
	@RequestMapping("/deposit")
	public String depositAmount() {
		return "deposit";
	}
	
	@RequestMapping("/Deposit")
	public String depositAmount(@RequestParam("accountNo") int accountNumber,@RequestParam("amount") double amount,Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException{
		SavingsAccount account = service.getAccountById(accountNumber);
		service.deposit(account, amount);
		model.addAttribute("account", account);
		return "GetAccounts";
	}

	@RequestMapping("/Account")
	public String UpdateAccountRedirect() {
		return "updateAccount";
	}
	@RequestMapping("/search")
	 public String searchedAccount(@RequestParam("searchAccountNo") int accountNumber,Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		 SavingsAccount account = service.getAccountById(accountNumber);
		 model.addAttribute("account", account);
		 return "GetAccounts";
	 }
	@RequestMapping("/update")
	public String UpdateTheAccount(@RequestParam("searchAccountNo") int accountNumber,Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = service.getAccountById(accountNumber);
		 model.addAttribute("account", account);
		 return "updatedform";
	}
	

	@RequestMapping("/updateAccount")
	public String UpdatedAccount(@RequestParam("accountHolderName") String accountHolderName,
			@RequestParam("rdSalary") boolean salary,Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = new SavingsAccount(accountHolderName, salary);
		account = service.updateAccount(account);
		model.addAttribute("account", account);
		return "GetAccounts";
	}

	@RequestMapping("/getAllTheAccounts") 
	public String getAllAccounts (Model model) throws ClassNotFoundException,SQLException {  
		accounts = service.getAllSavingsAccount();
		model.addAttribute("accounts",accounts);
	  return "GetAccounts";
	  }
	 @RequestMapping("/searchaccount")
	 public String searchAccount()  {
		 return "SearchAccount";
	 }

	 @RequestMapping("/transferfund")
	 public String transferFund() {
		 return "fundtransfer";
	 }
	 @RequestMapping("/transferFund")
	 public String transferedFund(@RequestParam("senderAccountNo") int senderAccountNumber,@RequestParam("receiverAccountNo") int receiverAccountNumber,@RequestParam("amount") double amount,Model model) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		 SavingsAccount sendersSavingsAccount = service.getAccountById(senderAccountNumber);
			SavingsAccount receiverSavingAccount = service.getAccountById(receiverAccountNumber);
			service.fundTransfer(sendersSavingsAccount, receiverSavingAccount, amount);
			model.addAttribute("accounts", accounts);
		 return "GetAccounts";
	 }
	 @RequestMapping("/sortByAccountBalance")
	 public String sortByAccountBalance(Model model) throws ClassNotFoundException, SQLException {
		 flag = !flag;
		 accounts = service.getAllSavingsAccount();
			if(flag){
			Collections.sort(accounts,new SortByAccountBalance());
			}else{
				Collections.sort(accounts,new SortByAccountBalanceInDescending());
			}
			model.addAttribute("accounts", accounts);
			return "GetAccounts";
	 }
	 
	 @RequestMapping("/sortByName")
	 public String sortByName(Model model) throws ClassNotFoundException, SQLException {
		 flag = !flag;
		 accounts = service.getAllSavingsAccount();
			if(flag){
			Collections.sort(accounts,new SortByAccountHolderName());
			}else{
				Collections.sort(accounts,new SortByAccountHolderNameInDescending());
			}
			model.addAttribute("accounts", accounts);
			return "GetAccounts";
	 }

}
