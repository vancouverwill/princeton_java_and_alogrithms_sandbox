package collections;

import java.util.Vector;

//import collections.MyStack.Node;

public class MyLinkedList<Item> {

	private int N; // number in collection;
	private Node first; 	// size of stack
	
	
	// helper linked list class
	private class Node {
		private Item item;
		private Node next;
		
		void appendToTail(Item d) {
			Node end = new Node();
			end.item = d;
			Node n = this;
			while (n.next != null) {
				n = n.next; 
				} 
			n.next = end;
		}
		
//		while (n.next != null) { if (n.next.data == d) {
//		n.next = n.next.next;
//		return head; /* head didn’t change */ }
//		n = n.next; }
//		}



		Node deleteNode(Node head, Item d) { 
			Node n = head;
			if (n.item == d) {
				return head.next; /* moved head */
			}
			while (n.next != null) { 
				if (n.next.item == d) {
					n.next = n.next.next;
					return head; /* head didn’t change */ 
				}
				n = n.next; 
			}
			return null;
		}
	}
	
//	public void appendToTail(Item d) {
//		Node end = new Node();
//		end.item = d;
//		MyLinkedList n = this;
//		while (n.next != null) 
//		{ n = n.next; } n.next = end;
//		}
}
