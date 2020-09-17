package com.codeprep.appenddelete;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static String appendAndDelete(String s, String t, int k) {

		int match = 0;
		char[] st = s.toCharArray();
		char[] tt = t.toCharArray();

		for (int i = 0; i < tt.length; i++) {

			if (i < tt.length && i < st.length && st[i] == tt[i]) {
				match++;
			}else {
				break;
			}
		}
		
		int totlen = tt.length + st.length;
		
		if(totlen <= 2 * match + k && totlen % 2 == k % 2 || totlen < k) {
			return "Yes";
		}
		else {
			return "No";
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String s = scanner.nextLine();

		String t = scanner.nextLine();

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = appendAndDelete(s, t, k);

		System.out.println(result);
		scanner.close();
	}
}
