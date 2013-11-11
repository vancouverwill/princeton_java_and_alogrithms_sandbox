package sorting;

import java.util.Iterator;

import collections.ResizingArrayQueue;
import standard_libraries.StdIn;
import standard_libraries.StdOut;

/*************************************************************************
 *  Compilation:  javac Shell.java
 *  Execution:    java Shell < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   http://algs4.cs.princeton.edu/21sort/tiny.txt
 *                http://algs4.cs.princeton.edu/21sort/words3.txt
 *   
 *  Sorts a sequence of strings from standard input using shellsort.
 *
 *  Uses increment sequence proposed by Sedgewick and Incerpi.
 *  The nth element of the sequence is the smallest integer >= 2.5^n
 *  that is relatively prime to all previous terms in the sequence.
 *  For example, incs[4] is 41 because 2.5^4 = 39.0625 and 41 is
 *  the next integer that is relatively prime to 3, 7, and 16.
 *   
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Shell < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *    
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *  
 *  % java Shell < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 *
 *************************************************************************/

public class Shell {

    // sort the array a[] in ascending order using Shellsort
    public static void sort(Comparable[] a) {
        int N = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        while (h < N/3) h = 3*h + 1; 

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            assert isHsorted(a, h); 
            h /= 3;
        }
        assert isSorted(a);
    }



   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
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


   /***********************************************************************
    *  Check if array is sorted - useful for debugging
    ***********************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array h-sorted?
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h])) return false;
        return true;
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
//        String[] a = StdIn.readStrings();
//	    	String num = StdIn.readString();
	    	int num = StdIn.readInt();

//	    	if (num != "-") {
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
        Shell.show(a);
        System.out.println("");
        Shell.sort(a);
        Shell.show(a);
    }

}
