package com.codeprep.caeser.cipher;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the caesarCipher function below.
	static String caesarCipher(String s, int k) {

		String small = "abcdefghijklmnopqrstuvwxyz";
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] sm = small.toCharArray();
		char[] c = caps.toCharArray();
		char[] test = s.toCharArray();
		k = k % 26;

		Map<Integer, String> smallMap = populate(sm);
		Map<Integer, String> capsMap = populate(c);
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < test.length; i++) {

			int asciiVal = test[i];
			String p = smallMap.get(asciiVal);
			String q = capsMap.get(asciiVal);

			if (p != null) {
				int sval = p.charAt(0) + k;
				if (sval > 'z') {
					builder.append(smallMap.get(sval - 26));
				} else {
					builder.append(smallMap.get(sval));
				}
			} else if (q != null) {
				int cval = q.charAt(0) + k;
				if (cval > 'Z') {
					builder.append(capsMap.get(cval - 26));
				} else {
					builder.append(capsMap.get(cval));
				}
			} else {
				builder.append(String.valueOf(test[i]));
			}
		}
		return builder.toString();
	}

	private static Map<Integer, String> populate(char[] a) {

		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			map.put((int) a[i], String.valueOf(a[i]));
		}
		return map;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = caesarCipher(s, k);

		System.out.println(result);
		scanner.close();
	}
}