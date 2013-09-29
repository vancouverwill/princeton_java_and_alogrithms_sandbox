package priorityQueues;

import java.util.Iterator;

import standard_libraries.StdIn;
import collections.ResizingArrayQueue;

/**
 * 318
 * @author will_melbourne
 *
 * @param <Key>
 */
public class SimpleMaxPQ<Key extends Comparable<Key>>
	  {
		private Key[] pq;             // heap-ordered complete binary tree
	     private int N = 0;            //    in pq[1..N] with pq[0] unused
	     
	     public SimpleMaxPQ(int maxN)
	     {  
	    	 pq = (Key[]) new Comparable[maxN+1];  
	    	 }
	
	     public boolean isEmpty()
	     {  
	    	 return N == 0;  
	    }
	
	     public int size()
	     {  
	    	 return N;  
	    }
	
	     public void insert(Key v)
		{
			pq[++N] = v;
			swim(N); 
		}
	     
	     
		public Key delMax()
		{
		   Key max = pq[1];
		   exch(1, N--);
		   pq[N+1] = null;
		   sink(1);
		return max; }
		
	// Retrieve max key from top.
	// Exchange with last item.
	// Avoid loitering.
	// Restore heap property.
	     // See pages 145-147 for implementations of these helper methods.
//	     private boolean less(int i, int j) {
//	    	 if (comparator == null) {
//	             return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
//	         }
//	         else {
//	             return comparator.compare(pq[i], pq[j]) < 0;
//	         }
//	     }
		
		private boolean less(int i, int j)
		  {  return pq[i].compareTo(pq[j]) < 0;  }
		
	     private void exch(int i, int j) {
	    	 Key swap = pq[i];
	         pq[i] = pq[j];
	         pq[j] = swap;
	     }
	     
	     private void swim(int k)
	     {
	        while (k > 1 && less(k/2, k))
	        {
	           exch(k/2, k);
	   k = k/2; }
	   }
	     
	     private void sink(int k)
	     {
	        while (2*k <= N)
	        {
	           int j = 2*k;
	           if (j < N && less(j, j+1)) j++;
	           if (!less(k, j)) break;
	           exch(k, j);
	           k = j;
	   
	        }
	     }
	     
	     public static void main (String[] args) {
	    	 
	    	 ResizingArrayQueue<Integer> queue = new ResizingArrayQueue();
	     	
	     	while (StdIn.hasNextChar()) {
//	         
	 	    	int num = StdIn.readInt();

	 	    	if (num < 0) {
	 	    		break;
	 	    	}
	 	    	else {
	 	    		queue.enqueue(num);
	 	    	}
	 	    	
	 	    	
	     	}
	     	
	     	System.out.println(queue.toString());
	     	
	     	System.out.println("You have " + queue.size() + " elements in your queue");
	     	
	     	String[] a = new String[queue.size()];
	     	
	     	SimpleMaxPQ<Integer> temp = new SimpleMaxPQ<Integer>(200);
	     	
	     	Iterator<Integer> itr = queue.iterator();
	         int count = 0;
	         while(itr.hasNext()) {
	            Integer element = itr.next();
	            String elementString = element.toString();
	            System.out.print(elementString + " ");
	            
	            a[count] = elementString;
	            
	            count++;
	            
	            temp.insert(element);
	         }
	         
	         System.out.println();
	         System.out.println(temp.size());
	         
	         temp.insert(77);
	         temp.insert(65);
	         temp.insert(73);
	         
	         System.out.println(temp.size());
	         
	         
	         
	     	
	     }
	}
