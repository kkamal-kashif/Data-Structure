package com.kk.linkedList;

import com.kk.linkedList.basic.Node;

//https://leetcode.com/problems/linked-list-cycle-ii/
//https://javabypatel.blogspot.com/2017/05/floyds-cycle-detection-algorithm-in-java.html
public class LinkedListCycleWithNode {
	static Node head;

	public static void main(String[] args) {
		LinkedListCycleWithNode linkedList = new LinkedListCycleWithNode();
		linkedList.push(61);
		linkedList.push(45);
		linkedList.push(78);
		linkedList.push(90);
		linkedList.push(41);
		linkedList.push(22);

		linkedList.print();
		System.out.println();
		head.next.next.next.next = head.next.next.next;
		System.out.println(linkedList.detectCycle().data);
	}

	private Node detectCycle() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				// After meet, moving slow to start node of list.
				slow = head;
				// Moving slow and fast one node at a time till the time they meet at common
				// point.
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				// returning start node of loop.
				return slow;
			}
		}
		// this condition will arise when there is no loop in list.
		return null;
	}

	void push(int val) {
		Node nn = new Node(val);
		nn.next = head;
		head = nn;
	}

	void print() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
}
