package com.kk.linkedList.basic;

public class MiddleEleOfLL {
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

		MiddleEleOfLL llist = new MiddleEleOfLL();
		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);
		
		/*Create loop for testing */
		//llist.head.next.next.next = llist.head;
		llist.printList();
		System.out.println();
		llist.printMiddle();

	}

	// middle element of linked list in one pass.
	// Floyd's Cycle detection algorithm
	private void printMiddle() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		if (head != null) {
			while (fast_ptr != null && fast_ptr.next != null) {
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
			System.out.println("middle element : " + slow_ptr.data);
		}
	}

	private void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;

	}

	private void printList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + "  ");
			n = n.next;
		}
	}

}
