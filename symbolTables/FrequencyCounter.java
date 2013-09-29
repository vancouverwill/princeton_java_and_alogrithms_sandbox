package symbolTables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import standard_libraries.StdArrayIO;
import standard_libraries.StdIn;
import standard_libraries.StdOut;

/*************************************************************************
 *  Compilation:  javac FrequencyCounter.java
 *  Execution:    java FrequencyCounter L < input.txt
 *  Dependencies: ST.java StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/31elementary/tnyTale.txt
 *                http://algs4.cs.princeton.edu/31elementary/tale.txt
 *                http://algs4.cs.princeton.edu/31elementary/leipzig100K.txt
 *                http://algs4.cs.princeton.edu/31elementary/leipzig300K.txt
 *                http://algs4.cs.princeton.edu/31elementary/leipzig1M.txt
 *
 *  Read in a list of words from standard input and print out
 *  the most frequently occurring word.
 *
 *  % java FrequencyCounter 1 < tinyTale.txt
 *  it 10
 *
 *  % java FrequencyCounter 8 < tale.txt
 *  business 122
 *
 *  % java FrequencyCounter 10 < leipzig1M.txt
 *  government 24763
 *
 *
 *************************************************************************/

public class FrequencyCounter {

    public static void main(String[] args) {

    	
    	//int     argSize = 1,
		
		
		int distinct = 0, words = 0;
		int minlen = Integer.parseInt(args[0]);
		ST<String, Integer> st = new ST<String, Integer>();
		
		// Optional 3rd argument 
		String  argFileName;
		
		// Are we reading from command line and stdin?
		
		// No - are we reading file input?
		if(args.length == 2)
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
		
			        
			        while (!StdIn.isEmpty()) {
			            String key = StdIn.readString();
			            if (key.length() < minlen) continue;
			            words++;
			            if (st.contains(key)) { st.put(key, st.get(key) + 1); }
			            else                  { st.put(key, 1); distinct++; }
			        }
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
		
        

        // compute frequency counts
       

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words  = " + words);
    }
}
