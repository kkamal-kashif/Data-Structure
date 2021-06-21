package com.kk.linkedList.basic;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		MyLL1 llist = new MyLL1();
		llist.push(1);
		llist.push(10);
		llist.push(85);
		llist.push(35);
		llist.push(16);
		llist.removeNthFromEnd(3);
		llist.print();
	}

}

class MyLL1 {
	Node head;

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

	public void removeNthFromEnd(int n) {
		Node p1 = head;
		Node p2 = head;

		while (p2 != null) {
			p2 = p2.next;
			n--;
			if (n < 0) {
				p1 = p1.next;
			}
		}
		System.out.println("element at nth post" + p1.data);
		//data exchange and delete the next one
		p1.data = p1.next.data;
		p1.next = p1.next.next;

	}

	public void print() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
}