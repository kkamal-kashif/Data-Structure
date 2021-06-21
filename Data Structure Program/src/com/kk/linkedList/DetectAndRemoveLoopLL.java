package com.kk.linkedList;

import com.kk.linkedList.basic.Node;

//https://javabypatel.blogspot.com/2017/05/how-floyds-cycle-finding-algorithm-work.html
public class DetectAndRemoveLoopLL {
	static Node head;

	public static void main(String[] args) {
		DetectAndRemoveLoopLL list = new DetectAndRemoveLoopLL();
		head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(67);
		head.next.next.next.next.next = new Node(10);
		System.out.println(head.next.next.next.next.next.data);
		// Creating a loop for testing
		head.next.next.next.next.next = head.next;

		list.detectAndRemoveLoop(head);
		System.out.println("Linked List after removing loop : ");
		list.printList(head);
	}

	void detectAndRemoveLoop(Node node) {
		// If list is empty or has only one node without loop
		if (node == null || node.next == null)
			return;

		Node slow = node, fast = node, prev = null;
		// prev , where loop starts, end side ie prev to loop node
		while (fast != null && fast.next != null) {
			slow = slow.next;
			// For capturing just previous node of loop node for setting it to null for
			// breaking loop.
			prev = fast.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("Loop identified at : =======" + slow.data);
				System.out.println("prev " + prev.data);
				slow = node;
				// If loop start node is starting at the root Node, then slow, fast and head all
				// point at same location. we already capture previous node, just setting it to
				// null will work in this case.
				if (slow == fast) {
					prev.next = null;
				} else {
					// need to first identify the start of loop node and then by setting just
					// previous node of loop node next to null.
					while (slow.next != fast.next) {
						slow = slow.next;
						fast = fast.next;
					}
					fast.next = null;
				}
			}
		}
	}

	private void printList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

}
