/*
 * Harsh Agrawal
 * CS 570 B
 * CWID : 10475285
 * Fall 2021
 */

package com.harshagrawal.learn.java;

public class IDLListTest {

	public static void main(String[] args) {
		IDLList<Integer> myList= new IDLList<Integer>();
		myList.add(10);
		myList.add(20);
		myList.add(30);
		myList.add(40);
		myList.add(500);
		myList.add(90);
		myList.add(500);
		myList.add(30);
		System.out.println(myList.toString());
		
		System.out.println(myList.remove());
		System.out.println(myList.toString());
		
		myList.append(5);
		System.out.println(myList.toString());
		
		myList.add(4, 6);
		System.out.println(myList.toString());
		
		System.out.println(myList.remove(500));
		System.out.println(myList.toString());
		
		System.out.println(myList.removeAt(2));
		System.out.println(myList.toString());
		
		System.out.println(myList.removeLast());
		System.out.println(myList.toString());
		
		System.out.println(myList.get(3));
		System.out.println(myList.getHead());
		System.out.println(myList.getLast());
		System.out.println(myList.toString());
	}

}
