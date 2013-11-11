package sorting.practice;

import standard_libraries.StdOut;

public class MergeTwoArrays {

	public static void main( String[] args)
	{
		StdOut.println("public class MergeTwoArrays ");
		
		int arraySize = 5;
		int[] arrayI= {0, 2, 4, 6, 8};
		int[] arrayJ= {0, 1, 3, 5, 7};
		
		int[] array3 = {0, 2, 4, 6, 8};
		
		int[] finalArray = new int[arraySize * 2];
		
		int i = 0, j = 0;
		
		show(finalArray);
		
		for (int k = 0; k < arraySize * 2; k++)
		{
			if (i>= arraySize) 					{ finalArray[k] = arrayJ[j++]; }
			else if (j >= arraySize) 			{ finalArray[k] = arrayI[i++]; }
			else if (arrayJ[j] < arrayI[i]) 	{ finalArray[k] = arrayJ[j++]; }
			else  								{ finalArray[k] = arrayI[i++]; }
				
			}
			
		show(finalArray);
		}
	
	 private static void show(int[] a) {
	    	
	        for (int i = 0; i < a.length; i++) {
//	            StdOut.println(a[i]);
	            StdOut.print(a[i] + " ");
	            
	        }
	        StdOut.println();
	        StdOut.println();
	    }
		
		
	
}
