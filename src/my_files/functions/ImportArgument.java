package src.my_files.functions;

public class ImportArgument {
	//--------------------------------------
	// This method is the application entry point.
	//
//	public static void main(         // Command line arguments as strings
//	                        String[] args)
//	{
//	            // Required arguments with initialized values
//	    int     argX = 1,
//	            argY = 1,
//
//	            // Read from 3rd file if running tests
//	            inputFileN = 1;
//
//	            // Optional 3rd argument 
//	    String  argFileName;
//
//	    // Are we reading from command line and stdin?
//	    if(args.length == 2)
//	    {
//	        // Yes - alright to try to do our thing
//	        try
//	        {
//	            // Get X and Y from command line
//	            argX = Integer.parseInt(args[0]);
//	            argY = Integer.parseInt(args[1]);
//
//	            // Inside this class data is read from stdin
//	            SomeSimulation someSimulation = new SomeClass(argX, argY);
//	        }
//	        catch(NumberFormatException ex)
//	        {
//	            // Show error
//	            StdOut.println("SomeApp::main() - An argument is not a parseable integer.");
//	        }
//	    } 
//	    else
//	    {
//	        // No - are we reading file input?
//	        if(args.length == 3)
//	        {
//	            // Yes - does the 3rd argument have some content?
//	            if(args[2].length() > 0)
//	            {
//	                // Yes - save the file we'll read from
//	                argFileName = args[2];
//
//	                try
//	                {
//	                    // Open the file and redirect to stdin 
//	                    System.setIn(new FileInputStream(argFileName));
//
//	                    // Get the N found in the input file that tells us how many pairs will be read
//	                    inputFileN = StdIn.readInt();
//
//	                    // Create someTest object
//	                    someTest = new SomeTest(inputFileN);
//
//	                    // Loop until input file is empty
//	                    while(!StdIn.isEmpty())
//	                    {
//	                            // Read the two elements to connect
//	                        int a = StdIn.readInt(),
//	                            b = StdIn.readInt();
//
//	                        // Do action
//	                        someTest.action(a, b);
//	                    }
//	                }
//	                catch(FileNotFoundException ex)
//	                {
//	                    // Show error
//	                    StdOut.println(ex.toString());
//	                }
//	            }
//	        }
//	        else
//	        {
//	            // No - show usage instructions
//	            StdOut.println("Command line arguments must be one of the following:");
//	            StdOut.println("    X Y");
//	            StdOut.println("    X Y path/filename.ext");
//	        }
//	    }      
//	}
}
