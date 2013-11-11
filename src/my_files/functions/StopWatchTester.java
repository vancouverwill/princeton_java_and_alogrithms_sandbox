package src.my_files.functions;

import standard_libraries.Newton;
import standard_libraries.StdOut;
import standard_libraries.StopWatch;

public class StopWatchTester {
	/*************************************************************************
	 *  The test client compares the method for computing square roots in
	 *  Java's Math library with our implementation from Program 2.1.1 th
	 *  uses Newton's method for the task of computing the sum of t
	 *  e square roots of the numbers from 0 to N-1. For this quick test,
	 *  the Java implementation Math.sqrt() is about 20 times faster than 
	 *  our Newton.sqrt() (as it should be!). 
	 *************************************************************************/
	    public static void main(String[] args) { 
//	        int N = Integer.parseInt(args[0]); 
	        
	        int N = 34;

	        // time Math library implementation
	        double totalMath = 0.0; 
	        StopWatch swMath = new StopWatch(); 
	        for (int i = 0; i < N; i++) {
	            totalMath += Math.sqrt(i); 
	        }
	        double timeMath = swMath.elapsedTime(); 
	  
	        // time Newton's method implementation
	        double totalNewton = 0.0; 
	        StopWatch swNewton = new StopWatch(); 
	        for (int i = 0; i < N; i++) {
	            totalNewton += Newton.sqrt(i);
	        }


	        // print results
	        System.out.println("time Newton");
	        double timeNewton = swNewton.elapsedTime(); 
	        
	        System.out.println("totalNewton / totalMatch");
	        StdOut.println(totalNewton/totalMath); 
	        
	        System.out.println("timeNewton / totalMatch");
	        StdOut.println(timeNewton/timeMath); 
	    }
}
