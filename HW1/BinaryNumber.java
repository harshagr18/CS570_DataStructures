/*
 * Harsh Agrawal
 * CS 570 B
 * CWID : 10475285
 * Fall 2021
 */


package com.harshagrawal.learn.java;
import java.util.Arrays;

public class BinaryNumber {
	
		private int data[]; // contains the binary number
		private boolean overflow; // used for addition operations
		
		public BinaryNumber(int length) { 
			
			// creating a binary number of length length and consisting only of zeros
			if(length>0) { 
			
			// Checking for zero or negative length input 
			data = new int[length];
			for(int i=0;i<length;i++) {
				data[i] = 0;} 
			}
			else {System.out.println("Either 0 or negative length entered");} // Error if improper length is input
		}
		
		
		public BinaryNumber(String str) { 
			
			// creating a binary number given a string
			int size = str.length();
			data = new int[size];
			
			for(int i=0;i<size;i++) {
			if(str.charAt(i)=='1' || str.charAt(i)=='0') { // Checking for improper inputs
			data[i] = Character.getNumericValue(str.charAt(i));}
			else{System.out.println("Error! Entered value was not binary.");break;} // Error if improper input values
			}
		}
		
		
		public int getLength(){ 
			
			// returning the length of a binary number
			return data.length;}

		
		public int getDigit(int index) { 
			
			// obtaining a digit of a binary number given an index
			return data[index];}


		public void shiftR(int amount) { 
			
			// shifting all digits in a binary number any number of places to the right
			data = Arrays.copyOf(data,(data.length+amount)); // increasing size of data to required length
			
			for(int i=0;i<amount;i++) { // shifting all digits to the right
				int t = data[data.length-1];
				
				for(int j=data.length-1;j>1;j--) {
					data[j] = data[j-1];}
				
				data[i] = t;}
		}
		
		
		public void add(BinaryNumber aBinaryNumber) { 
			
			
			// Add two binary numbers
			int userData[] = aBinaryNumber.data;
			if(data.length != userData.length) { // Checking for incorrect size of inputs
		    	System.out.println("The length of the binary numbers are not equal");
		    }else{
		    	int temp = 0;
		    	int sum = 0;
		    	
		    	for(int i=0; i<data.length;i++) {
		    		sum = data[i]+userData[i]+temp;
		    		
		    		
		    		switch(sum){
		    		
		    		case 0:{
		    			data[i]=0;
		    			temp=0;
		    			break;
		    		}
		    		case 1:{
		    			data[i]=1;
		    			temp=0;
		    			break;
		    		}
		    		case 2:{
		    			data[i]=0;
		    			temp=1;
		    			break;
		    		}
		    		case 3:{
		    			data[i]=1;
		    			temp=1;
		    			break;
		    		}
		    		}
		    		   
		    	}
		    	if(temp == 1) {overflow = true;}
		    }	
		}
		
		public String toString() {
			// Return the binary number as a string 
			if(overflow) {return "Overflow";}
			else {
				
				for(int i=0;i<data.length;i++) {
					System.out.print(data[i]);
				}
				return "";
			}
		}
		
		
		public int toDecimal() {
			
			// Return decimal value of the binary number
			int decimalValue = 0;
			int j = 0;
			for(int i=0; i<data.length; i++) {
				j = data[i];
				decimalValue += (j * Math.pow(2, i));}
			
			return decimalValue;
			
		}
		
		
		public void clearOverflow() {
			// Clears the overflow attribute of the binary number
			overflow = false;
		}
		
		
		public static void main(String args[]) {
			
			BinaryNumber b = new BinaryNumber(3);
			System.out.println(b.toString());
			BinaryNumber b1 = new BinaryNumber("11001"); // Initializing a new binary number
			System.out.println(Arrays.toString(b1.data)); // 
			System.out.println(b1.getLength());
			System.out.println(b1.getDigit(0));
			System.out.println(b1.toDecimal());
			b1.shiftR(4);
			System.out.println(b1.toString());
			BinaryNumber b2 = new BinaryNumber("001");
			BinaryNumber b3 = new BinaryNumber("010");
			b2.add(b3);
			System.out.println(b2.toString());
						
	}

}
