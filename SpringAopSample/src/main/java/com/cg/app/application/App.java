package com.cg.app.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cg.app.service.Calculator;
@Component
public class App {
	ApplicationContext context = new ClassPathXmlApplicationContext();
	Calculator calc = new Calculator();
	cal

}
