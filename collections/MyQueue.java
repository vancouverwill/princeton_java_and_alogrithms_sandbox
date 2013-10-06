package collections;

//import collections.Queue.Node;

public class MyQueue<Item> {
	private Node first;
	private Node last;
	private int N;
	
	private class Node {
		private Item item;
		private Node next;
	}
	
	public MyQueue() {
		first = null;
		last = null;
		N = 0;
	}
	
	/**
     * Is the queue empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the queue.
     */
    public int size() {
        return N;     
    }
    
    
    /**
     * Return the item least recently added to the queue.
     * @throws java.util.NoSuchElementException if queue is empty.
     */
    public Item peek() {
    	return first.item;
    }
    
    public void enqueue( Item item) {
    	Node oldLast = last;
    	last = new Node();
    	last.item = item;
    	last.next = null;
    	if (isEmpty()) first = last;
    	else oldLast.next = last;
    	N++;
    	assert check();
    }
    
    // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
            if (last  != null) return false;
        }
        else if (N == 1) {
            if (first == null || last == null) return false;
            if (first != last)                 return false;
            if (first.next != null)            return false;
        }
        else {
            if (first == last)      return false;
            if (first.next == null) return false;
            if (last.next  != null) return false;

            // check internal consistency of instance variable N
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next) {
               numberOfNodes++;
            }
            if (numberOfNodes != N) return false;

            // check internal consistency of instance variable last
            Node lastNode = first;
            while (lastNode.next != null) {
               lastNode = lastNode.next;
            }
            if (last != lastNode) return false;
        }

        return true;
    } 
}
