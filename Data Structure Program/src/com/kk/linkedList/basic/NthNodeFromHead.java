package com.kk.linkedList.basic;

public class NthNodeFromHead {
	static Node head;

	public static void main(String[] args) {
		NthNodeFromHead llist = new NthNodeFromHead();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);
		llist.push(85);
		llist.push(35);
		llist.push(16);
		System.out.println(getNth(2));
	}

	public static int getNth(int index) {
		int count = 0;     //index of Node we are currently looking at
		Node temp = head;
		while(temp != null){
			if(count == index) return temp.data;
			temp = temp.next;
			count++;
		}
		return -1;
	}

	private void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

}
