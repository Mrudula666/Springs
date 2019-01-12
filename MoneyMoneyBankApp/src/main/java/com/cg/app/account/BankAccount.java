package com.cg.app.account;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {
	private int accountNumber;
	private double accountBalance;
	private String accountHolderName;
	

	

	public BankAccount() {
		super();
	}

	public BankAccount(int accountNumber,String accountHolderName, double accountBalance) {
		this.accountNumber = accountNumber; 
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
	}

	public BankAccount(String accountHolderName,double accountBalance) {
		this.accountBalance = accountBalance;
		this.accountHolderName = accountHolderName;
	}
	

	public BankAccount(String accountHolderName) {
		super();
		this.accountHolderName = accountHolderName;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}
	
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance
				+ ", accountHolderName=" + accountHolderName + "]";
	}

}
