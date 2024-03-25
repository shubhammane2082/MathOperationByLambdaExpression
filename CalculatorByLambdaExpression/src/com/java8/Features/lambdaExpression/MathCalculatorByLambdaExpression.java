package com.java8.Features.lambdaExpression;

public class MathCalculatorByLambdaExpression {

	public static void main(String[] args) 
	{
		Mathoperations addition=(a,b) -> a+b;
		Mathoperations substraction=(a,b) -> a-b;
		Mathoperations multiplication=(a,b) -> a*b;
		Mathoperations division=(int a,int b) -> 
		{if(b<=0) return 0;
		 else return a/b;
		};
		
		System.out.println("Addition is : "+addition.calculate(10, 5));
		System.out.println("Substraction is : "+substraction.calculate(10, 5));
		System.out.println("Multiplication is : "+multiplication.calculate(10, 5));
		try {
			
			System.out.println("Division is : "+division.calculate(10, 3));
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		
		Mathoperations.printResult(10, 5, addition, "Addition");
		Mathoperations.printResult(10, 5, substraction, "Substraction");
		Mathoperations.printResult(10, 5, multiplication, "Multiplication");
		Mathoperations.printResult(10, 3, division, "Division");
	}

}
