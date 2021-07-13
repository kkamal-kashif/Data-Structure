package com.kk.linkedList.basic;

import com.kk.linkedList.basic.Try1.Node;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeWithoutAccessToHead {
	Node head;

	public static void main(String[] args) {
		DeleteNodeWithoutAccessToHead linkedList = new DeleteNodeWithoutAccessToHead();
		linkedList.push(61);
		linkedList.push(45);
		linkedList.push(78);
		linkedList.push(90);
		linkedList.push(22);
		linkedList.deleteNode(linkedList.head.next.next);
		linkedList.printList();

	}

	// just replace data with next node and remove next node
	private void deleteNode(Node del) {
		del.data = del.next.data;
		del.next = del.next.next;
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
