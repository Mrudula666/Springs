package com.cg.app.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.app.account.ui.AccountCUI;

public class Bootstrap {
	
	

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		AccountCUI account = context.getBean(AccountCUI.class);
		account.start();
	}

}
