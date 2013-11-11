package src.percolation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import standard_libraries.StdArrayIO;
import standard_libraries.StdDraw;
import standard_libraries.StdIn;
import standard_libraries.StdOut;
import standard_libraries.StdRandom;

/*************************************************************************
 *  Compilation:  javac VerticalPercolation.java
 *  Execution:    java VerticalPercolation < testEZ.txt
 *  Dependencies: StdArrayIO.java StdOut.java
 *
 *  % java VerticalPercolation < testD.txt
 *  8 8
 *  0 0 0 1 1 1 0 1
 *  1 1 1 0 0 1 1 1
 *  1 0 1 0 0 1 0 0
 *  1 0 1 1 1 1 0 0
 *  1 0 0 1 0 1 0 0
 *  1 1 0 1 0 0 0 0
 *  0 1 1 0 0 0 0 0
 *  0 0 1 0 0 0 0 0
 *  false
 *
 *  % java VerticalPercolation < testV.txt
 *  8 8
 *  0 0 0 1 1 1 0 1 
 *  0 0 0 0 0 1 0 1 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  0 0 0 0 0 1 0 0 
 *  true
 *
 *************************************************************************/

public class VerticalPercolation {

    // given an N-by-N matrix of open sites, return an N-by-N matrix
    // of sites reachable from the top via a vertical path of open sites
    public static boolean[][] flow(boolean[][] open) {
        int N = open.length;     
        boolean[][] full = new boolean[N][N];
        
        
        System.out.println("open length is " + N);

        // identify full sites in row 0
        for (int j = 0; j < N; j++) {
            full[0][j] = open[0][j]; 
        }      

        // update remaining rows
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                full[i][j] = open[i][j] && full[i-1][j];
            }
        }

        return full;
    } 


    // does the system percolate?
    public static boolean percolates(boolean[][] open) {
        int N = open.length;
        boolean[][] full = flow(open);
        for (int j = 0; j < N; j++) {
            if (full[N-1][j]) return true;
        }
        return false;
    }

    // draw the N-by-N boolean matrix to standard draw
    public static void show(boolean[][] a, boolean which) {
        int N = a.length;
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which)
                    StdDraw.filledSquare(j, N-i-1, .5);
    }

    // return a random N-by-N boolean matrix, where each entry is
    // true with probability p
    public static boolean[][] random(int N, double p) {
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }

   // test client
    public static void oldmain(String[] args) {
        boolean[][] open = StdArrayIO.readBoolean2D();
        
        boolean[][] full = flow(open);
        StdArrayIO.print(open);
        StdArrayIO.print(full);
        StdOut.println(percolates(open));
        show(full, true);
    }       
    
    public static void main(         // Command line arguments as strings
            String[] args)
	{
    	
    	// see Handling File Redirection in IDEs in PRINCETON
    	
    	
		// Required arguments with initialized values
		int     argSize = 1,
		
		
		// Read from 3rd file if running tests
		inputFileN = 1;
		
		// Optional 3rd argument 
		String  argFileName;
		
		// Are we reading from command line and stdin?
		//if(args.length == 2)
		//{
		// Yes - alright to try to do our thing
		//try
		//{
		//// Get X and Y from command line
		//argX = Integer.parseInt(args[0]);
		//argY = Integer.parseInt(args[1]);
		//
		//// Inside this class data is read from stdin
		//SomeSimulation someSimulation = new SomeClass(argX, argY);
		//}
		//catch(NumberFormatException ex)
		//{
		//// Show error
		//StdOut.println("SomeApp::main() - An argument is not a parseable integer.");
		//}
		
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
			
			        // Get the N found in the input file that tells us how many pairs will be read
			//        inputFileN = StdIn.readInt();
			
			        // Create someTest object
			//        someTest = new SomeTest(inputFileN);
			
			        // Loop until input file is empty
			//        while(!StdIn.isEmpty())
			//        {
			//                // Read the two elements to connect
			//            int a = StdIn.readInt(),
			//                b = StdIn.readInt();
			//
			//            // Do action
			//            someTest.action(a, b);
			//        }
			        
			        boolean[][] open = StdArrayIO.readBoolean2D();
			        
			        boolean[][] full = flow(open);
			        StdArrayIO.print(open);
			        StdArrayIO.print(full);
			        StdOut.println(percolates(open));
			        show(full, true);
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

