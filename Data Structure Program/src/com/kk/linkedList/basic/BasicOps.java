package com.kk.linkedList.basic;

public class BasicOps {

	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.push(61);
		obj.push(56);
		obj.push(89);
		obj.push(23);
		obj.push(21);
		System.out.println(obj.get(2).data);
		obj.addAtHead(34);
		obj.print();

		System.out.println();
		obj.addAtTail(56);
		obj.print();

		System.out.println();
		obj.addAtIndex(3, 81);
		obj.print();

		System.out.println();
		obj.deleteAtIndex(2);
		obj.print();

		obj.push(76);
		obj.push(231);
		System.out.println();
		obj.deleteByKey(81);
		obj.print();
	}

}

class MyLinkedList {
	Node head;

	/** Initialize your data structure here. */
	public MyLinkedList() {

	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public Node get(int index) {
		Node curr = head;
		int count = 0;
		while (curr != null && count < index) {
			count++;
			curr = curr.next;
		}
		return curr;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node cur = new Node(val);
		cur.next = head;
		head = cur;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		Node nn = new Node(val);
		if (head == null) {
			head = nn;
			return;
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = nn;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		Node curr = head;
		Node newNode = new Node(val);
		int c = 0;
		while (curr != null && c < index) {
			c++;
			curr = curr.next;
		}
		newNode.next = curr.next;
		curr.next = newNode;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		Node curr = head;
		Node prev = null;
		int count = 0;
		while (curr != null && count < index) {
			count++;
			prev = curr;
			curr = curr.next;
		}
		prev.next = prev.next.next;
	}

	public void push(int val) {
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

	public void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}

	}
	
	void deleteByKey(int key) {
		Node cn = head;
		if(cn != null && cn.data == key) {
			head = cn.next;
			return;
		}
		while(cn != null && cn.data != key) {
			cn = cn.next;
		}
		if(cn == null) return;
		else
			cn.next = cn.next.next;
	}

	//DeleteNodeWithNoAccessToHead
	public void deleteNode(Node node) {
		node.data = node.next.data;
		System.out.println(node.data);
		node.next = node.next.next;
	}
}