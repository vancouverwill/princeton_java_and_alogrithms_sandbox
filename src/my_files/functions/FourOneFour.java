package src.my_files.functions;
import java.util.Random;

import standard_libraries.StdRandom;



public class FourOneFour {

	private int horiztontalSize;
	private int verticalSize;
	
	public int createGrid(int size, int searchNumber) 
	{
		horiztontalSize = size;
		verticalSize = size;
		
		int[][] grid = null;
		
		for (int i = 0; i < horiztontalSize; i++) {
			for (int j = 0; j < verticalSize; j++) {
				Random randomNumber = new Random();
				
				
				int tempNumber = -1;
				
				while ( tempNumber < 0 ){
					 tempNumber = randomNumber.nextInt();
				}
				
				grid[horiztontalSize][verticalSize] = tempNumber;
				System.out.println(tempNumber);
			}
        }
		
		
		for (int i = 0; i < horiztontalSize; i++) {
			for (int j = 0; j < verticalSize; j++) {
				if (grid[horiztontalSize][verticalSize] == searchNumber) {
					return 1;
				}
			}
        }
		return 0;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourOneFour sampel = new FourOneFour();
		int results = sampel.createGrid(2, 45);
	}

}
