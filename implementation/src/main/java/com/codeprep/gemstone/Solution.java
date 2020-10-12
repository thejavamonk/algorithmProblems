package com.codeprep.gemstone;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	static int gemstones(String[] arr) {

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {

			char[] chars = arr[i].toCharArray();
			Set<String> set = new HashSet<>();
			for (int j = 0; j < chars.length; j++) {
				set.add(String.valueOf(chars[j]));
			}
			
			for (String string : set) {
				Integer val = map.get(string);
				if(val == null) {
					map.put(string, 1);
				}
				else {
					map.put(string, val + 1);
				}
			}
		}

		int gems = 0;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue().equals(arr.length)) {
				gems++;
			}
		}
		return gems;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			String arrItem = scanner.nextLine();
			arr[i] = arrItem;
		}

		int result = gemstones(arr);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}