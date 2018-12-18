package com.anigy.spring.aop.impl;

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

//切点优先级顺序
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	//切点表达式
	@Pointcut("execution(public int com.anigy.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void declareJoinPointExpression() {}

	//使用表达式
//	@Before("declareJoinPointExpression()")
//	public void beforeMethod(JoinPoint joinPoint) {
//		String methodName = joinPoint.getSignature().getName();
//		List<Object> args = Arrays.asList(joinPoint.getArgs());
//		System.out.println("The method " + methodName + " begins with " + args);
//	}
	
	//普通写法
	@Before("execution(public int com.anigy.spring.aop.impl.ArithmeticCalculator.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}

	@After("declareJoinPointExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " ends");
	}

	@AfterReturning(value = "declareJoinPointExpression()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}

	@AfterThrowing(value = "declareJoinPointExpression()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception with " + ex);
	}

//	@Around(value = "declareJoinPointExpression()")
//	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//		String methodName = proceedingJoinPoint.getSignature().getName();
//		List<Object> args = Arrays.asList(proceedingJoinPoint.getArgs());
//		Object result = null;
//		try {
//			
//			// 前置通知
//			System.out.println("The method " + methodName + " begins with " + args);
//			
//			result = proceedingJoinPoint.proceed();
//			
//			// 返回通知
//			System.out.println("The method " + methodName + " ends with " + result);
//			
//		} catch (Exception e) {
//			
//			// 异常通知
//			System.out.println("The method " + methodName + " occurs exception with " + e);
//			
//			throw new RuntimeException(e);
//		} finally {
//			
//			//后置通知
//			System.out.println("The method " + methodName + " ends");
//			
//		}
//		// 后置通知
//		return result;
//
//	}

}
