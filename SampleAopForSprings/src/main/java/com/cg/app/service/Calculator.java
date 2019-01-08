package com.cg.app.service;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	public Integer add(int number1,int number2) {
		//System.out.println(number1+number2);
		return (number1+number2);
	}

}
