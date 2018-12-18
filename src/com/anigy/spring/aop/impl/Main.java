package com.anigy.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		
		int result = arithmeticCalculator.div(3, 6);
		System.out.println("result: " + result);
		
//		result = arithmeticCalculator.add(30, 10);
//		System.out.println("result: " + result);
		
	}

}
