package com.codeprep.runningtime;

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
		int shift = 0;
		for (i = 1; i < lengthOfTheArray; i++){
			
			int temp = intArray[i];
			for(j = i-1 ; j >= 0 && intArray[j] > temp; j--){
					intArray[j + 1] = intArray[j];
					shift++;
			}
			intArray[j + 1] = temp;
		}
		System.out.println(shift);
	}
}
