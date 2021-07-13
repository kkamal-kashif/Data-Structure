package com.kk.linkedList.basic;

public class LengthAndSearchLL {
	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}

	}

	public static void main(String[] args) {
		LengthAndSearchLL linkedList = new LengthAndSearchLL();
		linkedList.push(61);
		linkedList.push(45);
		linkedList.push(78);
		linkedList.push(90);
		linkedList.push(22);
		linkedList.printList();
		System.out.println("----------");
		System.out.println("count iteratively : "+linkedList.getCountIteratively());
		System.out.println("count recursively :" +linkedList.getCountRecursively(linkedList.head));
		
		boolean searchIter = linkedList.searchIterative(linkedList.head, 9760);
		System.out.println("iteratively :"+searchIter);
		boolean searchRecur = linkedList.searchRecursive(linkedList.head, 22);
		System.out.println("recursively :"+searchRecur);    
	}
	
	private boolean searchRecursive(Node head, int val) {
			if(head == null) return false;
			if(head.data == val){
				return true;
			}
		return searchRecursive(head.next,val);
	}
	
	private int getCountRecursively(Node currentNode) {
		if(currentNode == null)return 0;
		int count = 1+getCountRecursively(currentNode.next);
		return count;
	}
	private int getCountIteratively() {
		Node temp = head;
		int count = 0;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	private boolean searchIterative(Node head, int val) {
		boolean result = false;
		Node current = head;
		while(current != null){
			if(current.data == val){
				result =  true;
			}
			current = current.next;
		}
		return result;
	
	}

	private void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + "  ");
			n = n.next;
		}
	}

	private void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;

	}

}
