package com.cg.app.account.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.app.account.SavingsAccount;
import com.cg.app.exception.AccountNotFoundException;

@Repository
public class SavingsAccountSJDaoImpl implements SavingsAccountDAO {

	Logger logger = Logger.getLogger(SavingsAccountSJDaoImpl.class.getName());
	@Autowired
	public JdbcTemplate template;

	public SavingsAccount createNewAccount(SavingsAccount account){
		template.update("INSERT INTO account_details VALUES(?,?,?,?,?,?)",
				new Object[] { account.getBankAccount().getAccountNumber(),
						account.getBankAccount().getAccountHolderName(), account.getBankAccount().getAccountBalance(),
						account.isSalary(), null, "SA" });

		return account;
	}

	public SavingsAccount updateAccount(SavingsAccount account) throws ClassNotFoundException, SQLException {

		template.update("UPDATE account_details SET  account_hn = ?, salary = ? WHERE account_number = ?",
				new Object[] { account.getBankAccount().getAccountHolderName(), account.isSalary(),
						account.getBankAccount().getAccountNumber() });
		return account;
	}

	public SavingsAccount getAccountById(int accountNumber)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = template.queryForObject("SELECT * FROM account_details where account_number=?",
				new Object[] { accountNumber }, new SavingAccountMap());
		return account;
	}

	public SavingsAccount deleteAccount(int accountNumber)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = getAccountById(accountNumber);
		template.update("DELETE FROM account_details WHERE account_number = ?", new Object[] { accountNumber });
		return account;
	}

	public List<SavingsAccount> getAllSavingsAccount() throws ClassNotFoundException, SQLException {
		List<SavingsAccount> list = template.query("SELECT * FROM account_details", new SavingAccountMap());
		return list;
	}

	public void updateBalance(int accountNumber, double currentBalance) throws ClassNotFoundException, SQLException {
		template.update("UPDATE account_details SET account_bal=? where account_number=?",
				new Object[] { currentBalance, accountNumber });

	}

	public void commit() throws SQLException {

	}

	public SavingsAccount getAccountByName(String accountHolderName)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = template.queryForObject("SELECT * FROM account_details where account_hn=?",
				new Object[] { accountHolderName }, new SavingAccountMap());
		return account;
	}

	public List<SavingsAccount> getAccountsBetweenMinimumAndMaximumValues(double minimum, double maximum)
			throws ClassNotFoundException, SQLException {
		List<SavingsAccount> list = template.query("SELECT * FROM account_details WHERE account_bal BETWEEN ? AND ?",
				new Object[] { minimum, maximum }, new SavingAccountMap());
		return list;
	}

	public SavingsAccount getCurrentBalance(int accountNumber)
			throws ClassNotFoundException, SQLException, AccountNotFoundException {
		SavingsAccount account = getAccountById(accountNumber);
		return account;
	}

}
