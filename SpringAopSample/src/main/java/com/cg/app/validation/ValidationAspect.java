package com.cg.app.validation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
	@Before("execution(* com.cg.app.service.Calculator.*(..))")
	public void getMessage() {
		System.out.println("Before the business logic");
	}
	@After("execution(* com.cg.app.service.Calculator.*(..))")
	public void getMessage2() {
		
	}
	

}
