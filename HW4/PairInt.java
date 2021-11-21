/*
Harsh Agrawal
CS 570 B
CWID : 10475285
Fall 2021
*/

package Maze;

public class PairInt {

	private int x;
	private int y;
	
	//Constructor
	public PairInt(int x, int y) {
		
		this.x=x;
		this.y=y;
	}
	
	// Get methods
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	// Set methods
	public void setX(int x) {
		
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	// Check equal object
	public boolean equals(Object p) {
    	 PairInt pInt= (PairInt)p;
    	 if(this.x==pInt.x && this.y==pInt.y) {return true;}
    	 else {return false;}
	}
	
	// Print object as string
	public String toString() {
		String str = "(" + String.valueOf(x) + "," + String.valueOf(y)+")";
		return str;
	}
	
	// Copy object
	public PairInt copy() {
		PairInt output= new PairInt(x,y);
		return output;	
	 }
	}
