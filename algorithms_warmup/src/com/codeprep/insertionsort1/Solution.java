package com.codeprep.insertionsort1;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int lengthOfTheArray = Integer.parseInt(scanner.next());
		int[] intArray = new int[lengthOfTheArray];
		for (int i = 0; i < lengthOfTheArray; i++) {
			intArray[i] = Integer.parseInt(scanner.next());
		}
		
		scanner.close();

		determinePosition(intArray);
	}

	private static void determinePosition(int[] testArray) {
		
		int lastValue = testArray[testArray.length - 1];
		for (int i = testArray.length - 2 ; i < testArray.length; i--) {
			if(i == -1){
				testArray[0] = lastValue;
				printArray(testArray);
				break;
			}
			if(testArray[i] > lastValue){
				testArray[i + 1] = testArray[i];
				printArray(testArray);
			}else{
				testArray[i + 1] = lastValue;
				printArray(testArray);
				break;
			}
		}
	}
	
	private static void printArray(int[] intArray){
		
		String output = null;
		for (int i : intArray) {
			if(output != null){
				output = output +" "+ new Integer(i).toString();
			}else{
				output = new Integer(i).toString();
			}
		}
		System.out.println(output);
	}
}
