package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

import standard_libraries.StdIn;
import standard_libraries.StdOut;

//import collections.Stack.Node;

public class MyStack<Item> implements Iterable<Item>
{
	private int N; // number in collection;
	private Node first; 	// size of stack
	
	
	// helper linked list class
	private class Node {
		private Item item;
		private Node next;
	}
	
	 /**
     * Create an empty stack.
     */
	private MyStack() {
		first = null;
		N = 0;
		assert check();
	}
	
	
	/**
     * Add the item to the stack.
     */
    public void push(Item item)
    {
    	Node oldFirst = first;
    	first = new Node();
    	first.next = oldFirst;
    	first.item = item;
    	N++;
    	assert check();
    }
    
    
    /**
     * Delete and return the item most recently added to the stack.
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public Item pop() 
    {
    	if(isEmpty()) throw new NoSuchElementException("Stack underflow");
    	Item item = first.item;
    	first = first.next;
    	N--;
    	assert check();
    	return item;
    }
	
	 /**
     * Return string representation.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
    
    
    public boolean isEmpty()
    {
    	return first == null;
    }
    
    /**
     * Return the number of items in the stack.
     */
    public int size()
    {
    	return N;
    }
    
    
    
    
    
    /**
     * Return the item most recently added to the stack.
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public Item peek()
    {
    	if(isEmpty()) throw new NoSuchElementException("Stack underflow");
    	return first.item;
    }
    
    
    /**
     * Return an iterator to the stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() { return new ListIterator(); }
    
 // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
    	private Node current = first;

		@Override
		public boolean hasNext() { return current != null; }

		@Override
		public Item next() { 
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() { throw new UnsupportedOperationException(); }
    }
	
    
	 // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
        }
        else if (N == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable N
        int numberOfNodes = 0;
        for (Node x = first; x != null; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != N) return false;

        return true;
    } 
    
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (item.equals("*")) { break; }
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
