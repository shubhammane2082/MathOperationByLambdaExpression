package com.java8.Features.lambdaExpression;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlaylist {

	public static void main(String[] args) 
	{
		List<Integer> numberPlaylist=new ArrayList<>();
		
		for(int i=0;i<5;i++)
		{
			numberPlaylist.add(i);
		}
		
		Iterator<Integer> it=numberPlaylist.iterator();
		while(it.hasNext())
		{
			Integer i=it.next();
			System.out.println(i+" ");
		}
		System.out.println();
		
		//By using Anonymous class
		class myConsumer implements Consumer<Integer>{
			@Override
			public void accept(Integer t) {

				System.out.println("By using Anonymous class : "+t);
			}
		}
		myConsumer action1=new myConsumer();
		numberPlaylist.forEach(action1);
		System.out.println();
		
		//Explicit Lambda Expression
		Consumer<Integer> action= n ->{
			System.out.println("Number List element by using Lambda Expression : "+n);
		};
		numberPlaylist.forEach(action);
		System.out.println();
		
		//Implicit Lambda Expression
		numberPlaylist.forEach(n ->{
			System.out.println("Number List element by using for Each is : "+n);
		});
		System.out.println();
		//print each element in double
		Function<Integer, Double> convertTodouble= n -> n.doubleValue();
		numberPlaylist.forEach(n -> System.out.println("Value after converting is : "+convertTodouble.apply(n)));
		System.out.println();
		
		//printEvenfunction
		
		Predicate<Integer> evenfunction = n -> n>0 && n%2==0;
		numberPlaylist.forEach(n -> System.out.println("Value of "+n+" is "+evenfunction.test(n)));
		System.out.println();
		
		//create stream and iterate
		numberPlaylist.stream().forEach(n -> 
		System.out.println("created stream here and iterate through each : "+n));
		
		//Transform all element to double 
		numberPlaylist.stream().
		                        filter(evenfunction)
		                        .map(convertTodouble)
		                        .collect(Collectors.toList());
	}

}
