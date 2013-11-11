package sorting.practice;

import java.util.Random;

import standard_libraries.StdOut;

public class QuickSortBigArray {
	
//	private static double[] a;
//	private static int N;

	public static void main(String[] args)
	{
		int[] array= {4, 0, 5, 1, 9, 133434};
		
		int N = array.length;
		
		Random random = new Random();
		
		show(array);
		
//		for (int i = 0; i < N; i++)
//		{
//			int r = i + random.nextInt(N - i); //replacement
//			int temp = array[i];
//			array[i] = array[r];
//			array[r] = temp;
//		}
		
		sort( array, 0, array.length - 1);
		
	}
	
	private static void sort( int[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition( a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, lo, j + 1);
		
	}
	
	private static int partition( int[] array, int lo, int hi)
	{
		int i = lo;
		int j = hi + 1;
		int comparable = array[lo];
		
		while(true) {
			while (less(array[++i], comparable)) {
				if (i >= hi) break;
			}
			
			while (less(comparable, array[--j])) {
				if (j <= lo) break;
			}
			
			if(i >= j) break;
			exch(array, i, j);
		}
		
		exch(array, lo, j);
		
		return j;
		
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}
	
	private static void exch( int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	 private static void show(int[] a) {
	        for (int i = 0; i < a.length; i++) {
	            StdOut.print(a[i] + " ");
	        }
	        StdOut.println();
	    }
}
