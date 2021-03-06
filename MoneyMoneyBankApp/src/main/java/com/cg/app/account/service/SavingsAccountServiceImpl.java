package com.cg.app.account.service;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.app.account.SavingsAccount;
import com.cg.app.account.dao.SavingsAccountDAO;
import com.cg.app.account.factory.AccountFactory;
import com.cg.app.exception.AccountNotFoundException;
import com.cg.app.exception.InsufficientFundsException;
import com.cg.app.exception.InvalidInputException;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService {

	private AccountFactory factory;
	@Autowired
	public SavingsAccountDAO savingsAccountDAO;

	public SavingsAccountServiceImpl() {
		factory = AccountFactory.getInstance();
	}

	public SavingsAccount createNewAccount(String accountHolderName, double accountBalance, boolean salary)
			throws ClassNotFoundException, SQLException {
		SavingsAccount account = factory.createNewSavingsAccount(accountHolderName, accountBalance, salary);
		savingsAccountDAO.createNewAccount(account);
		return account;
	}

	public List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException, SQLException {
		return savingsAccountDAO.getAllSavingsAccount();
	}

	public void deposit(SavingsAccount account, double amount) throws ClassNotFoundException, SQLException {
		if (amount > 0) {
			double currentBalance = account.getBankAccount().getAccountBalance();
			currentBalance += amount;
			savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InvalidInputException("Invalid Input Amount!");
		}
	}

	public void withdraw(SavingsAccount account, double amount) throws ClassNotFoundException, SQLException {
		double currentBalance = account.getBankAccount().getAccountBalance();
		if (amount > 0 && currentBalance >= amount) {
			currentBalance -= amount;
			savingsAccountDAO.updateBalance(account.getBankAccount().getAccountNumber(), currentBalance);
			// savingsAccountDAO.commit();
		} else {
			throw new InsufficientFundsException("Invalid Input or Insufficient Funds!");
		}
	}

	@Transactional
	public void fundTransfer(SavingsAccount sender, SavingsAccount receiver, double amount)
			throws ClassNotFoundException, SQLException {

		withdraw(sender, amount);
		deposit(receiver, amount);

	}

	public SavingsAccount updateAccount(SavingsAccount account) throws ClassNotFoundException, SQLException, AccountNotFoundException {
		return savingsAccountDAO.updateAccount(account);
	}

	public SavingsAccount getAccountById(int accountNumber)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		return savingsAccountDAO.getAccountById(accountNumber);
	}

	public SavingsAccount deleteAccount(int accountNumber)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		return savingsAccountDAO.deleteAccount(accountNumber);
	}

	public SavingsAccount getAccountByName(String accountHolderName)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		return savingsAccountDAO.getAccountByName(accountHolderName);
	}

	public List<SavingsAccount> getAccountsBetweenMinimumAndMaximumValues(double minimum, double maximum)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return savingsAccountDAO.getAccountsBetweenMinimumAndMaximumValues(minimum, maximum);
	}

	public SavingsAccount getCurrentBalance(int accountNumber)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		// TODO Auto-generated method stub
		return savingsAccountDAO.getCurrentBalance(accountNumber);
	}

}
