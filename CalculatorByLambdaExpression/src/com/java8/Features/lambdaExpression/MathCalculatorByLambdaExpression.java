package com.java8.Features.lambdaExpression;

public class MathCalculatorByLambdaExpression {

	public static void main(String[] args) 
	{
		Mathoperations addition=(a,b) -> a+b;
		Mathoperations substraction=(a,b) -> a-b;
		Mathoperations multiplication=(a,b) -> a*b;
		Mathoperations division=(a,b) -> a+b;
		
		System.out.println("Addition is : "+addition.calculate(10, 5));
		System.out.println("Substraction is : "+substraction.calculate(10, 5));
		System.out.println("Multiplication is : "+multiplication.calculate(10, 5));
		System.out.println("Division is : "+division.calculate(10, 5));
		
		System.out.println();
		
		Mathoperations.printResult(10, 5, addition, "Addition");
		Mathoperations.printResult(10, 5, substraction, "substraction");
		Mathoperations.printResult(10, 5, multiplication, "multiplication");
		Mathoperations.printResult(10, 5, division, "division");
	}

}
