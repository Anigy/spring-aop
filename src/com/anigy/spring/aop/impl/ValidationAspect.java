package com.anigy.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class ValidationAspect {

	@Before("LoggingAspect.declareJoinPointExpression()")
	public void validateArgs(JoinPoint joinpoint) {
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		String methodName = joinpoint.getSignature().getName();
		System.out.println("validate: " + methodName + " input value is: " + args);
	}
	
}
