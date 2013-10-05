package sorting;

import java.util.Iterator;

import collections.ResizingArrayQueue;
import standard_libraries.StdIn;
import standard_libraries.StdOut;
import standard_libraries.StdRandom;

public class MyQuickSort {

	
	public static void  quicksort(Comparable[] a){
		StdRandom.shuffle(a);
		sort(a, 0, a.length -1);
	}
	
	 // quicksort the array
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }
	
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
		assert isSorted( a, lo, hi);
		
	}
	
	
	// partition the subarray a[lo .. hi] by returning an index j
    // so that a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	private static int partition( Comparable[] a, int lo, int hi)
	{
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {
			
			 // find item on lo to swap
			while (less(a[++i], a[lo])) {
				if (i == hi) break;
			}
			
			// find item on hi to swap
			while (less(a[lo], a[--j])) {
				if (j == lo) break;   
			}
			
			 // check if pointers cross
			if (i >= j) break;
			
			exch(a, i, j);
		}
		// put v = a[j] into position
		exch(a, lo, j);
		
		return j;
	}
	
	
	private static boolean less( Comparable v, Comparable w)
	{
		return (v.compareTo(w) < 0);
	}
	
	private static void exch( Object[] a, int i, int j)
	{
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	
	 /***********************************************************************
	    *  Check if array is sorted - useful for debugging
	    ***********************************************************************/
	private static boolean isSorted(Comparable[] a)
	{
		return isSorted( a, 0, a.length -1);
	}
	
	
	private static boolean isSorted(Comparable[] a, int lo, int hi)
	{
		for ( int i = lo + 1; i <= hi; i++) {
			if (less(a[i], a[i - 1])) return false;
		}
		return true;
//		return isSorted( a, )
	}
	
	// print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
	
	
	 // Read strings from standard input, sort them, and print.
    public static void main(String[] args) {
//        String[] a = StdIn.readStrings();
    	
    	ResizingArrayQueue<Integer> queue = new ResizingArrayQueue();
    	
    	while (StdIn.hasNextChar()) {
	    	int num = StdIn.readInt();
	    	if (num < 0) {
	    		break;
	    	}
	    	else {
	    		queue.enqueue(num);
	    	}
    	}
    	
    	System.out.println(queue.toString());
    	String[] a = new String[queue.size()];
    	
//    	System.out.print("Original contents of al: ");
    	Iterator<Integer> itr = queue.iterator();
        int count = 0;
        while(itr.hasNext()) {
           Integer element = itr.next();
           String elementString = element.toString();
           System.out.print(elementString + " ");
           
           a[count] = elementString;
           
           count++;
        }
        
        MyQuickSort.sort(a);
        show(a);

        // display results again using select
        StdOut.println();
        for (int i = 0; i < a.length; i++) {
            String ith = (String) Quick.select(a, i);
            StdOut.println(ith);
        }
    }
}
