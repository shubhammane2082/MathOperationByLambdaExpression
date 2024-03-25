package com.java8.Features.lambdaExpression;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		System.out.println();
		
		//Transform all element to double 
		List<Double> evenstreamList = numberPlaylist.stream().
		                        filter(evenfunction)
		                        .peek(n -> System.out.println("Even Number is : "+n))
		                        .map(convertTodouble)
		                        .collect(Collectors.toList());
		
		System.out.println("List of Even Numbers is : "+evenstreamList);
		System.out.println();
		
		Integer firstevenNumber=numberPlaylist.stream()
				                                      .filter(evenfunction)
				                                      .findFirst()
				                                      .orElse(null);
		System.out.println("First Even Number is : "+firstevenNumber);
		System.out.println();
		
		Integer min=numberPlaylist.stream()
				                           .filter(evenfunction)
				                           .min((x,y) -> x-y)
				                           .orElse(null);
		
		System.out.println("Minimum Even Number is : "+min);
		
		Integer max=numberPlaylist.stream()
				                           .max(Comparator.comparing(Integer::intValue))
				                           .orElse(null);
		
		System.out.println("Maximum Even Number is : "+max+"\n");
		
		Integer sum=numberPlaylist.stream()
				                          .reduce(0, Integer::sum);
		
		int count=(int) numberPlaylist.stream().count();
		
		double avg=sum/count;
		System.out.println("Sum of Number Stream is : "+sum);
		System.out.println("Avg of Number Stream is : "+avg+"\n");
		
		//print all match even number or At least one match
		boolean allMatch = numberPlaylist.stream().allMatch(evenfunction);
		boolean anyMatch = numberPlaylist.stream().anyMatch(evenfunction);
		System.out.println("All elements are even :"+allMatch);
		System.out.println("At least one element is even in list : "+anyMatch);
		
		List<Integer> sortBynumber = numberPlaylist.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted Array List is : "+sortBynumber);
        }
}
