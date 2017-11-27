package com.codeprep.insertionsort2;

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
		insertionSort(intArray, lengthOfTheArray);
	}
	
	public static void insertionSort(int[] intArray, int lengthOfTheArray){
		
		int i, j;
		for (i = 1; i < lengthOfTheArray; i++){
			
			int temp = intArray[i];
			for(j = i-1 ; j >= 0 && intArray[j] > temp; j--){
					intArray[j + 1] = intArray[j];
			}
			intArray[j + 1] = temp;
			printArray(intArray);
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
