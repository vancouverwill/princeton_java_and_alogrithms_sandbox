package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

//import sorting.Quick;
import standard_libraries.StdArrayIO;
import standard_libraries.StdIn;
import standard_libraries.StdOut;
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
	
	
	public static void mainReadFilesToArray(String[] args) 
	{
		mainReadFiles( args);
	}
	
	
	public static void mainReadFiles(String[] args)
	{
    	
		// Required arguments with initialized values
		int     argSize = 1;
		
		// Optional 3rd argument 
		String  argFileName;
		
		// No - are we reading file input?
		if(args.length == argSize)
		{
			// Yes - does the 3rd argument have some content?
			if(args[1].length() > 0)
			{
			    // Yes - save the file we'll read from
			    argFileName = args[1];
			
			    try
			    {
			        // Open the file and redirect to stdin 
			        System.setIn(new FileInputStream(argFileName));
			
			        
//			        boolean[][] open = StdArrayIO.readBoolean2D();
//			        
//			        boolean[][] full = flow(open);
//			        StdArrayIO.print(open);
//			        StdArrayIO.print(full);
//			        StdOut.println(percolates(open));
//			        show(full, true);
			    }
			    catch(FileNotFoundException ex)
			    {
			        // Show error
			        StdOut.println(ex.toString());
			    }
			}
		}
		else
		{
			// No - show usage instructions
			StdOut.println("Command line arguments must be one of the following:");
			StdOut.println("    X  path/filename.ext");
		}
	}      

}
