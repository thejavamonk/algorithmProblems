package com.codeprep.exploremars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		int count = 0;
		Scanner in = new Scanner(System.in);
		String testString = in.next();
		in.close();

		List<String> messages = getParts(testString, 3);
		for (String string : messages) {
			if (!string.equals("SOS")) {
				count = count + changedLetters(string);
			}
		}

		System.out.println(count);
	}

	private static List<String> getParts(String string, int partitionSize) {
		List<String> parts = new ArrayList<>();
		int length = string.length();
		for (int i = 0; i < length; i += partitionSize) {
			parts.add(string.substring(i, Math.min(length, i + partitionSize)));
		}
		return parts;
	}

	private static int changedLetters(String message) {

		int count = 0;
		char[] messageChars = message.toCharArray();
		for (int i = 0; i < messageChars.length; i++) {
			if (i == 0 || i == 2) {
				if (!('S' == messageChars[i]))
					count++;
			} else if (i == 1) {
				if (!('O' == messageChars[i]))
					count++;
			}
		}
		return count;
	}

}
