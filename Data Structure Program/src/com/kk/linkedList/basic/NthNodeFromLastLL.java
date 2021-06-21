package com.kk.linkedList.basic;

//https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
public class NthNodeFromLastLL {
	static Node head;

	public static void main(String[] args) {

		NthNodeFromLastLL llist = new NthNodeFromLastLL();
		llist.push(20);
		llist.push(85);
		llist.push(35);
		llist.push(16);

		llist.printList();
		System.out.println("\n2nd node from last :" + llist.getNthLastNodeFromLinkList(2));

	}

	// Incrementing ptr2 to nth position from start, p1 keeping at head node until ptr2 reaches nth position.
	// After ptr2 reaches nth position, both pointer will advance one node at a time until ptr2 reaches NULL.
	// When ptr2 reaches NULL, ptr1 will be at Nth node away from last.
	private int getNthLastNodeFromLinkList(int pos) {
		if (pos <= 0 || head == null)
			return -1;
		Node ptr1 = head;
		Node ptr2 = head;

		while (ptr2 != null) {
			ptr2 = ptr2.next;
			pos--;
			// ptr1 will only move when ptr2 reached nth position.
			if (pos < 0) {
				ptr1 = ptr1.next;
			}
		}
		// If nthPosition is greater than 0, it means nthPosition is larger than
		// the number of nodes present and such position doesn't exist, so
		// return -1 in that case
		// else return data pointed by ptr1.
		if (pos <= 0) {
			return ptr1.data;
		}
		return -1;
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
