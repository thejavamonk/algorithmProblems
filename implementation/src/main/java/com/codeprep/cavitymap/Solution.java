package com.codeprep.cavitymap;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the cavityMap function below.
	static String[] cavityMap(String[] grid) {

	    for(int i=1; i<grid.length-1; i++){
	        for(int j=1; j<grid.length-1; j++){
	            int left = Character.getNumericValue(grid[i].charAt(j-1));
	            int right = Character.getNumericValue(grid[i].charAt(j+1));
	            int up = Character.getNumericValue(grid[i-1].charAt(j));
	            int down = Character.getNumericValue(grid[i+1].charAt(j));
	            int middle = Character.getNumericValue(grid[i].charAt(j));
	            char mid = grid[i].charAt(j);

	            if(left<middle && up<middle && right<middle && down<middle){

	                    StringBuilder sb = new StringBuilder(grid[i]);
	                    sb.setCharAt(j, 'X');
	                    grid[i] = sb.toString();
	            }
	        }
	    }
		return grid;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] grid = new String[n];

		for (int i = 0; i < n; i++) {
			String gridItem = scanner.nextLine();
			grid[i] = gridItem;
		}

		String[] result = cavityMap(grid);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);

			if (i != result.length - 1) {
				System.out.println("\n");
			}
		}
		scanner.close();
	}
}