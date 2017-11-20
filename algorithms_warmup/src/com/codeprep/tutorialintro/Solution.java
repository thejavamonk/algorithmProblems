package com.codeprep.tutorialintro;

import java.util.Scanner;

public class Solution {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int valueToCheckFor = in.nextInt();
		int sizeOfArray = in.nextInt();
		int arr[] = new int[sizeOfArray]; 
		
		for(int arr_i=0; arr_i < sizeOfArray; arr_i++){
            arr[arr_i] = in.nextInt();
        }
		
		for (int i = 0; i < arr.length; i++){
			
			if(valueToCheckFor == arr[i]){
				System.out.println(i);
			}
		}
	}
}
