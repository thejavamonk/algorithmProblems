package com.codeprep.largestelement;

import java.util.Scanner;

public class Solution {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		int largest, size, i;
		int arr[] = new int[50];
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Array Size : ");
		size = scan.nextInt();

		System.out.print("Enter Array Elements : ");
		for (i = 0; i < size; i++) {
			arr[i] = scan.nextInt();
		}

		System.out.print("Searching for the Largest Element....\n\n");

		largest = arr[0];

		for (i = 0; i < size; i++) {
			if (largest < arr[i]) {
				largest = arr[i];
			}
		}
		System.out.print("Largest Element = " + largest);

	}

}
