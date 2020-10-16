package com.codeprep.makinganagram;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	// Complete the makingAnagrams function below.
	static int makingAnagrams(String s1, String s2) {

		int cArr[] = new int[26];
		for (int i = 0; i < s1.length(); i++)
			cArr[s1.charAt(i) - 97]++;
		for (int i = 0; i < s2.length(); i++)
			cArr[s2.charAt(i) - 97]--;
		int count = 0;
		for (int i = 0; i < 26; i++)
			count += Math.abs(cArr[i]);
		return count;
	}

	static Map<String, Integer> populateMap(String s) {

		Map<String, Integer> sMap = new HashMap<>();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			Integer freq = sMap.get(String.valueOf(arr[i]));
			if (freq == null) {
				sMap.put(String.valueOf(arr[i]), 1);
			} else {
				sMap.put(String.valueOf(arr[i]), freq + 1);
			}
		}
		return sMap;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s1 = scanner.nextLine();

		String s2 = scanner.nextLine();

		int result = makingAnagrams(s1, s2);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}