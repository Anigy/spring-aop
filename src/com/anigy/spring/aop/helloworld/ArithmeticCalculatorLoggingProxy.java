package com.anigy.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Objects;

public class ArithmeticCalculatorLoggingProxy {

	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}
	
	public ArithmeticCalculator getLoggingProxy() {
		ArithmeticCalculator proxy = null;
		
		//��̬����
		
		//����������ĸ���������������
		ClassLoader loader = target.getClass().getClassLoader();
		//�����������ͣ�����������Щ����
		Class [] interfaces = new Class[] {ArithmeticCalculator.class};
		//�����ô���������еķ���ʱ����ִ�еĴ���
		InvocationHandler handler = new InvocationHandler() {
			/**
			 * proxy: ���ڷ��ص��Ǹ��������һ����invoke�����ж���ʹ�øö���
			 * method�� ���ڱ����õķ���
			 * args�� ���÷���ʱ����Ĳ���
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
				Object result = method.invoke(target, args);
				System.out.println("The method " + methodName + " ends with " + result);
				return result;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}
	
}
