/*
Harsh Agrawal
CS 570 B
CWID : 10475285
Fall 2021
*/

package treapPackage;

import java.util.Random;
import java.util.Stack;


public class Treap<E extends Comparable<E> > {
	
	private static class Node<E>{
		public E data;
		public int priority;
		public Node <E > left;
		public Node <E > right;
		
		//Constructor
		public Node(E data, int priority) {
			if(data==null) {
			System.out.println("No data provided");
			}
			else {
				this.left=null;
				this.right=null;
				this.data=data;
				this.priority=priority; 
			   			    }}
			
			
			
			public Node<E> rotateRight(){//Right rotate
				
				    Node<E> temp = this.left;
					Node<E> left = temp.right;
					temp.right = this;
					this.left = left;
					return temp;
				}	
			
			
			
			public Node<E> rotateLeft() {//Left rotate
				Node<E> temp = this.right;
				Node<E> right = temp.left;
				temp.left = this;
				this.right = right;
				return temp;
			}
			
			public String toString() {
				return this.data.toString();
			
			}}
		
		private Random priorityGenerator;
		private Node<E> root;
		
		
		public Treap() {//Empty treap
			priorityGenerator = new Random();
			root = null;
		}
		
		public Treap(long seed) {//Empty treap and priorityGenerator
			
			priorityGenerator = new Random(seed);
			root = null;
		}
	// Methods
		
	private boolean find(Node<E> root,E key) {
		if(!(root!=null)) {
			return false;
		}
		if(!(key.compareTo(root.data) != 0)) {
			return true;
		} 
		else if(!(key.compareTo(root.data) >= 0)) {
				return find(root.left,key);
			} 
		else {
				return find(root.right,key);
			}}

		
	boolean add(E key, int priority) {
		 if (!(root != null)) {
		  root = new Node<E>(key, priority);
			return true;
			}
		 else {
		  Node<E> n = new Node<E>(key, priority);
		  Stack<Node<E>> stack = new Stack<Node<E>>();
		  Node<E> localroot = root;
		 while (localroot != null) {
		  localroot.data.compareTo(key);
		  if (!(localroot.data.compareTo(key) != 0)) {
			 return false;
					}
		  else {
			  if (!(localroot.data.compareTo(key) >= 0)) {
				stack.push(localroot);
				if (localroot.right == null) {
				  localroot.right = n;
				  reheap(n, stack);
	            	return true;
					}
			else {
				localroot = localroot.right;
							}
				}
		else { 
			stack.push(localroot);
			if (!(localroot.left != null)) {
			 localroot.left = n;
			 reheap(n, stack);
			 return true;
			}
		else {
			localroot = localroot.left;
			}}
			  }
				}
			return false;
			}
		}
	
	boolean add(E key) {
		return add(key, priorityGenerator.nextInt());
	}
	
	
	public void reheap(Node<E> child, Stack<Node<E>> stack) {
		while (true) {
		Node<E> parent = stack.pop();
		if (!(parent.priority >= child.priority)) {
		 if ( !(parent.data.compareTo(child.data) <= 0)) {
			child = parent.rotateRight();
			}
		 else {
		child = parent.rotateLeft();
			}
	 if (!stack.isEmpty()) {
		if (!(stack.peek().left != parent)) {
			stack.peek().left = child;
		}
		else {
		stack.peek().right = child;
						}
	 }
	 else { 
	    this.root = child;
		}}
		else {
		   break;
		 }if(stack.isEmpty()) {break;}
		}
		}

	public boolean delete(E key) {
		if ( root == null || find(key) == false) {
			return false;
		} else {
			root = delete(key, root);
			return true;
		}
	}
	
	public boolean find(E key) {
		if(!(key!=null)) {
			System.out.println("Null key passed");
		}
		return find(root, key);
	}
	
	private Node<E> delete(E key, Node<E> localroot){//Delete function
	  if (!(localroot != null)) {
		return localroot;
	   }
	 else {
	   if (!(localroot.data.compareTo(key) >= 0)) {
		 localroot.right = delete(key, localroot.right);
		}
	   else {
		  if (!(localroot.data.compareTo(key) <= 0)) {
			localroot.left = delete(key, localroot.left);
			}
	  else {
		if (!(localroot.right != null)) {
		  localroot = localroot.left;
			}
		else if (!(localroot.left != null)) {
		  localroot = localroot.right;
			}
		else {
		  if (!(localroot.right.priority >= localroot.left.priority)) {
			localroot = localroot.rotateRight();
			 localroot.right = delete(key, localroot.right);
			  }
		 else {
			localroot = localroot.rotateLeft();
		    localroot.left = delete(key, localroot.left);
			}}}
			}
		 }
		 return localroot;
		 }
	
	
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder strbuilder) {
		int i = 0;
		while(i< depth){
			strbuilder.append("  ");
			i++;
		}
		if (!(node != null)) {
			strbuilder.append("null\n");
		} 
		else {
			strbuilder.append("(key = " + node.toString() + ", ");
			strbuilder.append("priority = ");
			strbuilder.append(node.priority);
			strbuilder.append(")");
			strbuilder.append("\n");
			preOrderTraverse(node.left, depth + 1, strbuilder);
			preOrderTraverse(node.right, depth + 1, strbuilder);
		}
	}
	
	public String toString() {
		StringBuilder strbuilder = new StringBuilder();
		preOrderTraverse(root, 1, strbuilder);
		return strbuilder.toString();
	}


	public static void main(String[] args) {
		Treap<Integer> testTree = new Treap<Integer>();
		testTree.add(4,19); 
		testTree.add(2,31);
		testTree.add(6,70); 
		testTree.add(1,84);
		testTree.add(3,12); 
		testTree.add(5,83);
		testTree.add(7,26);
		System.out.println(testTree.delete(2));
		System.out.println(testTree.find(3));
		System.out.println(testTree.toString());
	}
}