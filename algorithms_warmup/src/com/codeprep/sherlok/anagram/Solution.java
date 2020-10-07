package com.codeprep.sherlok.anagram;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				char[] valC = s.substring(i, j + 1).toCharArray();
				Arrays.sort(valC);
				String val = new String(valC);
				if (map.containsKey(val))
					map.put(val, map.get(val) + 1);
				else
					map.put(val, 1);
			}
		}
		int anagramPairCount = 0;
		for (String key : map.keySet()) {
			int n = map.get(key);
			anagramPairCount += (n * (n - 1)) / 2;
		}
		return anagramPairCount;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			System.out.println(String.valueOf(result));
		}
		scanner.close();
	}
}
