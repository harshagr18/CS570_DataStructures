/*
 * Harsh Agrawal
 * CS 570 B
 * CWID : 10475285
 * Fall 2021
 */

package com.harshagrawal.learn.java;

public class Complexity {
	
		// Method 1: Complexity = O(n^2).
		public static void method1(int n) {
			int counter = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.println("Operation " + counter);
					counter++; 
					}}
			System.out.println("Time complexity O(n^2) = " + counter);
		 }
		
		// Method 2: Complexity = O(n^3)
		 public static void method2(int n) {
			 int counter = 0;
			 for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
						for (int k = 0; k < n; k++) {
							System.out.println("Operation " + counter);
							counter++;
						}
					}
			 	}
			 System.out.println("Time complexity O(n^3) = " + counter);
		 }
		 // Method 3: Complexity = O(log n)
		 public static void method3(int n) {
			 int counter = 0;
			 for (int i = 1; i < n; i = i * 2) {
				 System.out.println("Operation " + counter); // Counted number of operations performed
				 counter++;
			 }
			 System.out.println("Time complexity O(log n) = " + counter);
		 }
		 //Method 4: Complexity = O(n log n):
		 public static void method4(int n) {
			 int counter = 0;
			 for (int i = 1; i <= n; i++) {
				    for(int j = 1; j < n; j = j * 2) {
				    	System.out.println("Operation " + counter);
				    	counter++;
				    }
			}
			 System.out.println("Time complexity O(nlogn) = " + counter);
		 }
		 
	     //Method 5: Complexity = O(log log n).
		 public static void method5(int n) {
			 int counter = 0;
			 for (double i = 2; i < n; i = i * i) {
				 System.out.println("Operation " + counter);
				 counter++;
			}
			 System.out.println("Time complexity O(loglogn) = " + counter);
		 }
			 
		 //Method 6:complexity = O(2^n) using the tower of Hanoi problem.
		 static int newnum = 0;
		 public static int method6(int n) {
			
			 
			 if(n == 1) {
				 newnum++;
				 System.out.println("Operation " + newnum);
				 return newnum;
			 }
			 method6(n-1);
			 newnum++;
			 System.out.println("Operation " + newnum);
			 method6(n-1);
			 return newnum+1;
		 }
			
		public static void main(String[] args) {
			System.out.println("Method with complexity - O(n^2):");
			method1(5);
			System.out.println("Method2 with complexity - O(n^3):");
	        method2(5);
	        System.out.println("Method3 with complexity - O(log n):");
	        method3(5);
	        System.out.println("Method4 with complexity - O(n log n):");
	        method4(5);
	        System.out.println("Method5 with complexity - O(log log n):");
	        method5(5);
	        System.out.println("Method6 with complexity - O(2^n):");
	        System.out.println("Time complexity O(2^n) is: " + method6(4));
		}
}
