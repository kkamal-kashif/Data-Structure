package com.kk.linkedList.basic;

public class CustomLinkedList {
	static Node head;
	static {
		push(61);
		push(56);
		push(89);
		push(23);
		push(21);
	}

	public static void push(int val) {
		Node curr = head;
		Node newNode = new Node(val);
		if (curr == null) {
			head = newNode;
			return;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public static void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}

	}

}
