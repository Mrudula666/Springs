package com.cg.app.validation;


import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {
	
	public static Logger logger = Logger.getLogger(ValidationAspect.class.getName());
	
	 /* @Before("execution(* com.cg.app.service.Calculator.*(..))") public void
	  getMessage1() { logger.info("Before Add Method"); }
	  
	  @After("execution(* com.cg.app.service.Calculator.*(..))") public void
	  getMessage() { logger.info("After Add Method"); }*/
	 
	@Around("execution(* com.cg.app.service.Calculator.*(..))")
	public Integer getMessage2(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Before Add method");
		Object[] params = joinPoint.getArgs();
		for (int i = 0; i < params.length; i++) {
			logger.info("Parameter "+i+" "+params[i]);
		}
		 Integer result = (Integer)joinPoint.proceed(); 
		logger.info("After Add method");
		return result;
	}
	@AfterReturning(pointcut="execution(* com.cg.app.service.Calculator.*(..))", returning = "retValue")
	public void valueReturned(Integer retValue) {
		logger.info("Result is "+retValue);
	}
}
