package utilities;

import java.util.Iterator;

//import sorting.Quick;
import standard_libraries.StdIn;
//import standard_libraries.StdOut;
import collections.ResizingArrayQueue;

public class ImportStyles {
	
	public static int[] readIntsUntilNegativeToArray(String[] args) {
  	
	  	ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<Integer>();
	  	
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
	  	int[] a = new int[queue.size()];
	  	
	//  	System.out.print("Original contents of al: ");
	  	Iterator<Integer> itr = queue.iterator();
	      int count = 0;
	      while(itr.hasNext()) {
	         Integer element = itr.next();
	         String elementString = element.toString();
//	         System.out.print(elementString + " ");
	         
//	         a[count] = (Integer)elementString;
	         a[count] = element;

	         
	         count++;
	      }
	      
	      return a;
	      
  }
	
	public static String[] readStringsUntilSymbolToArray(String[] args) {
		
		return readStringsUntilSymbolToArray(args, "-");
	}
	
	
	
	public static String[] readStringsUntilSymbolToArray(String[] args, String symbolDefault) {
	  	
	  	ResizingArrayQueue<String> queue = new ResizingArrayQueue<String>();
	  	
	  	while (StdIn.hasNextChar()) {
	  			String string = StdIn.readString();
		    	if (string.equals(symbolDefault)) {
		    		System.out.println("begin break");
		    		break;
		    	}
		    	else {
		    		System.out.println("enqeue string'" + string + "'");
		    		queue.enqueue(string);
		    	}
	  	}
	  	System.out.println("ended while");
	  	
	  	System.out.println(queue.toString());
	  	String[] a = new String[queue.size()];
	  	
	//  	System.out.print("Original contents of al: ");
	  	Iterator<String> itr = queue.iterator();
	      int count = 0;
	      while(itr.hasNext()) {
	    	  String element = itr.next();
	         String elementString = element.toString();
//	         System.out.print(elementString + " ");
	         
	         a[count] = elementString;
//	         a[count] = element;

	         
	         count++;
	      }
	      
	      return a;
	      
  }

}
