package com.cg.app.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
	
	public void add(int number1,int number2) {
		System.out.println(number1+number2);
	}
	
}
