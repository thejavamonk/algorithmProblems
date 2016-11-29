package com.codeprep.funnystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		List<String> testStrings = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		Integer noOfTests = new Integer(scanner.next());

		for (int i = 0; i < noOfTests.intValue(); i++) {
			testStrings.add(scanner.next());
		}
		scanner.close();

		for (String string : testStrings) {
			if(computeStringStatus(string, getReverseString(string))){
				System.out.println("Funny");
			}else{
				System.out.println("Not Funny");
			}
		}
	}

	private static String getReverseString(String testString) {
		char[] in = testString.toCharArray();
		int begin = 0;
		int end = in.length - 1;
		char temp;
		while (end > begin) {
			temp = in[begin];
			in[begin] = in[end];
			in[end] = temp;
			end--;
			begin++;
		}
		return new String(in);
	}

	private static boolean computeStringStatus(String testString, String reversedString) {
		
		int [] resultForTestString = computeValue(testString);
		int [] resultForreverseString = computeValue(reversedString);
		return Arrays.equals(resultForTestString, resultForreverseString);
	}

	private static int [] computeValue(String testString) {
		char[] input = testString.toCharArray();
		int [] results = new int [input.length];
		for (int i = 1, j = 0; i < input.length; i++) {
			int val1 = (int) input[i];
			int val2 = (int) input[i - 1];
			results[j] = Math.abs(val1 - val2);
			j++;
		}
		return results;
	}

}
