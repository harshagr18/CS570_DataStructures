/*
 * Harsh Agrawal
 * CS 570 B
 * CWID : 10475285
 * Fall 2021
 */


package com.harshagrawal.learn.java;

import java.util.ArrayList;
public class IDLList<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices = new ArrayList<>();

	private static class Node<E> {		
		E data;
		private Node<E> next = null;
		private Node<E> prev = null;
		Node (E elem) {
			this.data = elem;
		}
		Node (E elem, Node<E> prev, Node<E> next) {
			this.data = elem;
			this.prev = prev;
			this.next = next;
		}
	}
    
		//Empty double-linked list initialization
		public IDLList() {
			head = null;
			tail = null;
			size = 0;
		}
		
			// Prints list as string
			public String toString() {
				Node<E> mainNode = head;
				StringBuilder output = new StringBuilder();
				int i = 0;
				for (i = 0; mainNode != null;i++) {
					output.append(mainNode.data);
					if (mainNode.next != null) {
						output.append(" > ");
					}
					mainNode = mainNode.next;
				}
				return output.toString();
			}
		
		//Add element at head
		public boolean add(E elem) {
			if(head == null) {
				Node<E> temp = new Node<E>(elem);
				temp.data = elem;
				tail = temp;
				head = temp;
				indices.add(head);
				size++;
				return true;
			} else {
				Node<E> temp = new Node<E>(elem);
				temp.next = head;
				head.prev = temp;
				head = temp;
				indices.add(0,temp);
				size++;
				return true;
			}

		}
		
		
		//Add element as tail
		public boolean append(E elem) {
			if(size == 0) {
				tail.data = elem;
				head.data = elem;
				indices.add(head);
				size++;
				return true;
			} else {
				Node<E> temp = new Node<E>(elem);
				tail.next = temp;
				temp.prev = tail;
				tail = temp;
				indices.add(tail);
				size++;
				return true;
			}
		}
		
		//Removes and returns tail
				public E removeLast() {
					if (size == 0) { System.out.println("Size of list is 0");}
					if(tail == head) {
						Node<E> temp = head;
						tail = null;
						head = null;
						size--;
						return temp.data;
					}
					tail = tail.prev;
					tail.next = null;
					size--;
					return indices.remove(size).data;
				}

		//Returns object at given position
		public E get(int index) {
			if (index < 0) { System.out.println("Inappropriate index passed");}
			if (index >= size) { System.out.println("Inappropriate index passed");}
			return this.indices.get(index).data;
		}
		
		
		//Returns head
		public E getHead() {
			return head.data;
		}
		
		//Returns tail
		public E getLast() {
			return tail.data;
		}
		
		//Returns size
		public int size() {
			return size;
		}
		
		//Removes and returns head
		public E remove() {
			if (head == null) { System.out.println("Size of list is 0"); return null;}
			if(tail == head) {
				Node<E> temp = head;
				head = null;
				tail = null;
				size--;
				return temp.data;
			}
			head = head.next;
			head.prev = null;
			size--;
			return indices.remove(0).data;
		}
		
		//Removes and returns element at given position
		public E removeAt(int index) {
			if (index < 0) { System.out.println("Inappropriate index passed");}
			if (index >= size) { System.out.println("Inappropriate index passed");}
			if(index == 0) {
				E temp = this.remove();
				return temp;
			}
			
			Node<E> temp = indices.get(index);
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			size--;
			return indices.remove(index).data;
		}
		
		//Add element at given position
		public boolean add(int index, E elem) {
			if (index < 0) { System.out.println("Inappropriate index passed"); return false;}
			if (index > size) { System.out.println("Inappropriate index passed"); return false;}
				Node<E> curr = indices.get(index);
				Node<E> temp = new Node<E>(elem , curr.prev, curr);
				curr.prev.next = temp;
				curr.prev = temp;
				indices.add(index,temp);
				size++;
				return true;
			}
		
		//Removes first occurrence of element
		public boolean remove(E elem) {
			Node<E> temp = head;
			int i = 0;
			int j = 0;
			for(j = 0; temp.next != null;j++){
				if(temp.data.equals(elem)){
					if(i == 0) {
							head = head.next;
							size--;
							indices.remove(0);
							return true;
					}
					temp.next.prev = temp.prev;
					temp.prev.next = temp.next;
					size--;
					indices.remove(i);
					return true;
				}
				temp = temp.next;
				i++;
			}
			return false;
		}
	}
