package com.codeprep.insertionsort1;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		String elements = null;
		Scanner scanner = new Scanner(System.in);
		int lengthOfTheArray = Integer.parseInt(scanner.next());
		for (int i = 0; i < lengthOfTheArray; i++) {
			elements = elements +" "+ scanner.next();
		}
		scanner.close();

		String[] array = elements.split(" ");
		int[] intArray = new int[lengthOfTheArray];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = Integer.parseInt(array[i]);
		}
		determinePosition(intArray);
	}

	private static void determinePosition(int[] testArray) {
		int lastValue = testArray[testArray.length];
		int swap = testArray[testArray.length - 1];
		testArray[testArray.length] = swap;
		int start = testArray.length - 1;
		for (int i = start ; i < 0; i--) {
			if(testArray[start] > lastValue){
				testArray[start + 1] = testArray[start];
				System.out.println(testArray.toString());
			}else{
				testArray[start + 1] = lastValue;
				System.out.println(testArray.toString());
				break;
			}
		}
	}

}
