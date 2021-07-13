package com.kk.linkedList.basic;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
	static Node head;

	public static void main(String[] args) {
		LinkedListCycle linkedList = new LinkedListCycle();
		linkedList.push(61);
		linkedList.push(45);
		linkedList.push(78);
		linkedList.push(90);
		linkedList.push(41);
		linkedList.push(22);

		linkedList.print();
		System.out.println();
		head.next.next.next.next = head.next.next;
		System.out.println(linkedList.hasCycle());
		System.out.println(linkedList.hasCycle1());
	}

	// Time complexity : O(n). We visit each of the n elements in the list at most
	// once.Adding a node to the hash table costs only O(1) time.
	// Space complexity: O(n). The space depends on the number of elements added to
	// the hash table, which contains at most n elements.
	// Hash Table-record each node's reference (or memory address) in a hash table.
	private boolean hasCycle() {
		Node n = head;
		Set<Node> nodeSeen = new HashSet<>();
		while (nodeSeen != null) {
			if (nodeSeen.contains(n)) {
				return true;
			} else {
				nodeSeen.add(n);
			}
			n = n.next;
		}
		return false;
	}

	// Time complexity : O(n) total number of nodes in the linked list
	// Space complexity : O(1) use two nodes (slow and fast) so the SC is O(1).
	private boolean hasCycle1() {
		Node slow = head;
		Node fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
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
