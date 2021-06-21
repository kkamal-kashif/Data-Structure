package com.kk.linkedList.basic;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
//TC and SC - O(1)
public class DeleteNodeWithNoAccessToHead {

	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.push(61);
		obj.push(56);
		obj.push(89);
		obj.push(23);
		obj.push(21);
		obj.print();
		obj.deleteNode(obj.get(2)); // 89
		System.out.println();
		obj.print();
	}

}
