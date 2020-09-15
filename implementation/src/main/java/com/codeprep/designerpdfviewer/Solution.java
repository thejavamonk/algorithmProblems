package com.codeprep.designerpdfviewer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	// Complete the designerPdfViewer function below.
	static int designerPdfViewer(int[] h, String word) {

		char c;
		int i = 0;
		int max = 0;
		HashMap<String, Integer> map = new HashMap<>();

		for (c = 'a'; c <= 'z'; ++c) {
			map.put(String.valueOf(c), h[i]);
			i++;
		}

		char[] test = word.toCharArray();
		max = map.get(String.valueOf(test[0]));
		for (int j = 1; j < test.length; j++) {
			int k = map.get(String.valueOf(test[j]));
			if (k > max) {
				max = k;
			}
		}

		int area = max * test.length;
		return area;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int[] h = new int[26];

		String[] hItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 26; i++) {
			int hItem = Integer.parseInt(hItems[i]);
			h[i] = hItem;
		}

		String word = scanner.nextLine();

		int result = designerPdfViewer(h, word);

		System.out.println(result);
		scanner.close();
	}
}
