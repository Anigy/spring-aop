package com.anigy.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class LoggingAspect {
	
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}

	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " ends");
	}

	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}

	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception with " + ex);
	}

	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		String methodName = proceedingJoinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(proceedingJoinPoint.getArgs());
		Object result = null;
		try {
			
			// 前置通知
			System.out.println("The method " + methodName + " begins with " + args);
			
			result = proceedingJoinPoint.proceed();
			
			// 返回通知
			System.out.println("The method " + methodName + " ends with " + result);
			
		} catch (Exception e) {
			
			// 异常通知
			System.out.println("The method " + methodName + " occurs exception with " + e);
			
			throw new RuntimeException(e);
		} finally {
			
			//后置通知
			System.out.println("The method " + methodName + " ends");
			
		}
		// 后置通知
		return result;

	}

}
