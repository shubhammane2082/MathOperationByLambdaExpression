package com.java8.Features.lambdaExpression;

@FunctionalInterface
public interface Mathoperations {
	int calculate(int a,int b);
	
	public static void printResult(int a,int b,Mathoperations operations,String function)
	{
		System.out.println("Result of "+function+" is : "+operations.calculate(a, b));
	}
}
