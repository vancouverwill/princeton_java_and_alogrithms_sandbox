package sorting;

import java.util.Iterator;

import standard_libraries.StdIn;
import standard_libraries.StdOut;
import collections.ResizingArrayQueue;

public class MyMergeSort {

	
	public static void sort( Comparable[] a)
	{
		Comparable[] aux = new Comparable[a.length];
		sort( a, aux, 0, a.length);
		assert isSorted(a);
	}
	
	
	private static void sort( Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if (hi <= lo) return;
		int mid = lo + (hi -lo) / 2;
		sort(a, aux, lo, mid);
		sort(a , aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	 // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
	public static void merge( Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		// precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
		assert isSorted( a, lo, mid);
		assert isSorted( a, mid + 1, hi);
		
		// copy to aux[]
		for(int k = lo; k <= hi; k++)
		{
			aux[k] = a[k];
		}
		
		 // merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)					a[k] = a[j++];
			else if (j > hi)				a[k] = a[i++];
			else if (less(aux[j], aux[i])) 	a[k] = a[j++];
			else 							a[k] = a[i++];
		}
		assert isSorted( a);
	}
	
	
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
	
	// is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
 // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
    
    
    // use 
    // A E Q S U Y E I N O S T - 
    // to run
    // Read strings from standard input, sort them, and print.
    public static void main(String[] args) {
//        String[] a = StdIn.readStrings();
//        Merge.sort(a);
//        show(a);
    	
    	
    	ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
    	
    	while (StdIn.hasNextChar()) {
//	    	int num = StdIn.readInt();
//	    	if (num < 0) {
//	    		break;
//	    	}
	    	String string = StdIn.readString();
	    	if (string.equals("-")) {
	    		break;
	    	}
	    	else {
	    		queue.enqueue(string);
	    	}
    	}
    	
    	System.out.println(queue.toString());
    	String[] a = new String[queue.size()];
    	
//    	System.out.print("Original contents of al: ");
    	Iterator<String> itr = queue.iterator();
        int count = 0;
        while(itr.hasNext()) {
        	String element = itr.next();
           String elementString = element.toString();
           System.out.print(elementString + " ");
           
           a[count] = elementString;
           
           count++;
        }
    	
//        show(a, "before");
        Merge.sort(a);
//        show(a, "after");
        
//        System.out.println("CompareCount was " + compareCount);
//        System.out.println("ExchangeCounte was " + exchCount);
//        System.out.println("MergeCount was " + mergeCount);
    }

}
