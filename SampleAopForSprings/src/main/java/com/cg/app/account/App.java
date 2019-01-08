package com.cg.app.account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.app.service.Calculator;

public class App {
	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
	Calculator calc = context.getBean(Calculator.class);
	//calc.add(10,20);
	calc.add(10,29);
}
}
