package priorityQueues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

//import java.util.Comparator;

public class MyMinPriorityQueue<Key> implements Iterable<Key> {
	private Key[] pq;		 			// store items at indices 1 to N
	private int N;						// number of items on priority queue
	private Comparator<Key> comparator;	// optional comparator
	
	
	 /**
     * Create an empty priority queue with the given initial capacity.
     */
	public MyMinPriorityQueue(int initCapacity)
	{
		pq = (Key []) new Object[initCapacity + 1];
		N = 0;
	}
	
	/**
     * Create an empty priority queue.
     */
	public MyMinPriorityQueue() { this(1); }

	
	
	
	/**
     * Create an empty priority queue with the given initial capacity,
     * using the given comparator.
     */
	public MyMinPriorityQueue( int initCapacity, Comparator<Key> comparator) 
	{
		this.comparator = comparator;
		pq = (Key[]) new Object[initCapacity + 1];
		N = 0;
	}
	
	

	   /**
	 * Create an empty priority queue using the given comparator.
	 */
	public MyMinPriorityQueue( Comparator<Key> comparator) { this( 1, comparator); }
	
	
	
	 /**
     * Create a priority queue with the given items.
     * Takes time proportional to the number of items using sink-based heap construction.
     */
	
	
	 /**
     * Is the priority queue empty?
     */
	public boolean isEmpty() {
		return N == 0;
	}
	
	
	 /**
     * Return the number of items on the priority queue.
     */
	public int size() 
	{
		return N;
	}
	
	/**
     * Return the smallest key on the priority queue.
     * @throws java.util.NoSuchElementException if priority queue is empty.
     */
	public Key min() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}
	
	
	// helper function to double the size of the heap array
	private void resize(int newCapactiy)
	{
		assert newCapactiy > N;
		Key[] temp = (Key[]) new Object[newCapactiy];
		for (int i = 0; i < newCapactiy; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}
	
	 /**
     * Add a new key to the priority queue.
     */
	private void insert( Key x)
	{
		// double size of array if necessary
		if(N + 1 == pq.length) resize( 2 * pq.length);
		pq[N++] = x;
		swim(N);
		assert isMinHeap();
	}
	
	 /**
     * Delete and return the smallest key on the priority queue.
     * @throws java.util.NoSuchElementException if priority queue is empty.
     */
	private Key delMin()
	{
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		exch(1, N);
		Key min = pq[N--];
		sink(1);
		pq[N+1] = null; // avoid loitering and help with garbage collection
		if ((N > 0) && (N == ( pq.length - 1) / 2)) resize(pq.length / 2);
		assert isMinHeap();
        return min;
	}
	
	
	  /***********************************************************************
	    * Helper functions to restore the heap invariant.
	    **********************************************************************/
	private void swim( int k)
	{
		while(K > 1 && greater(k/2, k)) {
			exch(k,k/2);
			k = k/2;
		}
	}
	
	
	public void sink(int k)
	{
		while(2*k <= N) {
			int j = 2*k;
			if (j < N && greater(j, j+1)) j++;
			if (!greater(k,j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	

	 /**
	 * Return an iterator that iterates over all of the keys on the priority queue
	 * in ascending order.
	 * <p>
	 * The iterator doesn't implement <tt>remove()</tt> since it's optional.
	 */
	public Iterator<Key> iterator() { return new HeapIterator<Key>(); }
	
	private class HeapIterator<Key> implements Iterator<Key> 
	{
		 // create a new pq
		private MyMinPriorityQueue<Key> copy;
		
		
		
		// add all items to copy of heap
        // takes linear time since already in heap order so no keys move
		public HeapIterator() {
			if (comparator == null) copy = new MyMinPriorityQueue<Key>(size());
			else 					copy = new MyMinPriorityQueue<Key>(size(), comparator);
			
			for (int i = 0; i < N; i++) {
				copy.insert(pq[i]);
			}
		}



		@Override
		public boolean hasNext() {
			
			return !copy.isEmpty();
		}



		@Override
		public Key next() {
			if (!hasNext()) throw new NoSuchElementException();
			return copy.delMin();
		}



		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	
	/***********************************************************************
	* Helper functions for compares and swaps.
	**********************************************************************/
	private boolean greater( int i, int j)
	{
		if (comparator == null) {
			return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
		}
		else {
			return comparator.compare( pq[i], pq[j]) > 0;
		}
	}
	
	
	private void exch( int i, int j )
	{
		Key swap = pq[j];
		pq[j] = pq[i];
		pq[i] = swap;
	}
	
	 // is pq[1..N] a min heap?
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..N] rooted at k a min heap?
    private boolean isMinHeap(int k) {
    	if (k > N) return true;
    	int left = 2 *k, right = 2 * k + 1;
    	if (left <= N && greater(k, left)) return false;
    	if (right <= N && greater(k, right)) return false;
    	return isMinHeap(left) && isMinHeap(right);
    }
	
//	@Override
//	public Iterator<Key> iterator() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
