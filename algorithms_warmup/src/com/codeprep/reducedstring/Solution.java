package com.codeprep.reducedstring;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String initialInput = in.next();
		String finalOutput = null;

		char[] charArray = initialInput.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray.length > 0) {

				char first = charArray[i];
				char second = charArray[i++];
				if (first == second) {
					char[] newArray = new char [charArray.length - 2];
					for (int k = 0, j = i + 1; j < charArray.length; j++, k++) {
						newArray[k] = charArray[j];
					}
					charArray = newArray;
				}
			} else {
				System.out.println("Empty String");
			}
		}
		
		for (int i = 0; i < charArray.length; i++) {
			finalOutput = finalOutput + charArray[i];
		}
		System.out.println(finalOutput);
		in.close();
	}

}
