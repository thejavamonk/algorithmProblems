package com.codeprep.anagram;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	// Complete the anagram function below.
	static int anagram(String s) {

		int divisor = s.length() / 2;
		if (s.length() % 2 == 0) {

			String a = s.substring(0, divisor);
			String b = s.substring(divisor, s.length());

			char[] alets = a.toCharArray();
			char[] blets = b.toCharArray();
			int change = 0;

			Map<String, Integer> aletsCount = populate(alets);
			Map<String, Integer> bletsCount = populate(blets);

			for (String key : aletsCount.keySet()) {

				Integer val1 = aletsCount.get(key);
				Integer val2 = bletsCount.get(key);
				if (val1 != null && val2 != null) {
					if (val1 == val2) {
						aletsCount.put(key, 0);
						bletsCount.put(key, 0);
						continue;
					}

					if (val1 != val2) {
						if (val1 > val2) {
							aletsCount.put(key, Math.abs(val1 - val2));
							bletsCount.put(key, 0);
						}
						else {
							aletsCount.put(key, 0);
							bletsCount.put(key, Math.abs(val1 - val2));
						}
					}
				}
			}

			for (String key : aletsCount.keySet()) {
				change = change + aletsCount.get(key);
			}

			return change;
		} else {
			return -1;
		}
	}

	private static Map<String, Integer> populate(char[] letters) {

		Map<String, Integer> map = new HashMap<>();
		for (char c : letters) {
			Integer val = map.get(String.valueOf(c));
			if (val == null) {
				map.put(String.valueOf(c), 1);
			} else {
				map.put(String.valueOf(c), val + 1);
			}
		}
		return map;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = anagram(s);

			System.out.println(String.valueOf(result));
		}
		scanner.close();
	}
}
