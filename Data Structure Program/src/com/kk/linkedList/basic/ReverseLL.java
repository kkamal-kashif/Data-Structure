package com.kk.linkedList.basic;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLL {

	public static void main(String[] args) {
		MyLL2 llist = new MyLL2();
		llist.push(5);
		llist.push(4);
		llist.push(3);
		llist.push(2);
		llist.push(1);
		// llist.reverseList();
		llist.reverseRecursively(llist.head);
		llist.print();
	}

}

class MyLL2 {

	Node head;

	// Time Complexity: O(n)
	// Space Complexity: O(1)
	public void reverseList() {
		Node pn = null;
		Node cn = head;
		Node nn = head;

		while (nn != null) {
			nn = nn.next;
			cn.next = pn;
			pn = cn;
			cn = nn;
		}
		head = pn;
	}

	// In recursion Stack is used to store data.
	// Traverse linked list till we find the tail,that would be new head for
	// reversed linked list.
	// Tail Recursive Method
	void reverseRecursively(Node currentNode) {
		// check for empty list
		if (currentNode == null)
			return;

		// if we are at the TAIL node:recursive base case:
		if (currentNode.next == null) {
			head = currentNode; // set HEAD to current TAIL since we are reversing list
			return; // since this is the base case
		}
		reverseRecursively(currentNode.next);
		currentNode.next.next = currentNode;
		currentNode.next = null; // set "old" next pointer to NULL
	}

	public void push(int val) {
		Node cn = head;
		Node nn = new Node(val);
		if (cn == null) {
			head = nn;
			return;
		}
		nn.next = head;
		head = nn;
	}

	public void print() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

}