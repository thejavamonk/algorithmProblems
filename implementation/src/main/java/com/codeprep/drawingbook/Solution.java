package com.codeprep.drawingbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	/*
	 * Complete the pageCount function below.
	 */
	static int pageCount(int n, int p) {

		int forward = count(0, 1, n, p, true);
		int backward = 0;

		if (n % 2 == 0) {
			backward = count(n, 0, n, p, false);
		} else {
			backward = count(n, n - 1, n, p, false);
		}

		if (forward > backward) {
			return backward;
		} else {
			return forward;
		}
	}

	static int count(int a, int b, int n, int p, boolean forward) {

		int count = 0;
		if (forward) {
			for (int i = 0; i <= n; i++) {
				if (a == p || b == p) {
					return count;
				} else {
					count++;
					b = b + 2;
					a = a + 2;
				}
			}
		} else {
			for (int i = n; i > 0; i--) {
				if (a == p || b == p) {
					return count;
				} else {
					count++;
					if (n % 2 == 0) {
						b = a - 1;
						a = a - 2;
					} else {
						a = a - 2;
						b = b - 2;
					}
				}
			}
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		int p = scanner.nextInt();

		int result = pageCount(n, p);

		System.out.println(String.valueOf(result));
		scanner.close();
	}
}