package com.java8.Features.lambdaExpression;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

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
		
			
	}

}
