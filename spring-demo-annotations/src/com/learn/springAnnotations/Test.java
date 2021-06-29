package com.learn.springAnnotations;

import java.util.*;

public class Test {

	public static void main(String args[]) {
		
		LinkedList<String> list = new LinkedList<>();
		list.add("Hi");
		list.addFirst("Hello");
		list.add(0,"abhishek");
		list.addLast("Who let's");
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
            
	}

}
