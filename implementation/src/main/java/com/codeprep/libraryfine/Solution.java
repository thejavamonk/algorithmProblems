package com.codeprep.libraryfine;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Solution {

	// Complete the libraryFine function below.
	static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

		// check if date == due date
		// if date is greater than due date
		// check if date withing the due month
		// if date after the due month and same year
		// if date is after the year
		// if date is less than due date

		// Create SimpleDateFormat object
		try {
			SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");

			// Get the two dates to be compared
			Date returnDate = sdfo.parse(y1 + "-" + m1 + "-" + d1);
			Date dueDate = sdfo.parse(y2 + "-" + m2 + "-" + d2);

			if (returnDate.before(dueDate) || dueDate.equals(returnDate)) {
				return 0;
			} else if (returnDate.after(dueDate)) {
				if (m1 == m2 && y1 == y2) {
					return 15 * (d1 - d2);
				} else if (m1 > m2 && y1 == y2) {
					return 500 * (m1 - m2);
				} else if (y1 > y2) {
					return 10000;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] d1M1Y1 = scanner.nextLine().split(" ");

		int d1 = Integer.parseInt(d1M1Y1[0]);

		int m1 = Integer.parseInt(d1M1Y1[1]);

		int y1 = Integer.parseInt(d1M1Y1[2]);

		String[] d2M2Y2 = scanner.nextLine().split(" ");

		int d2 = Integer.parseInt(d2M2Y2[0]);

		int m2 = Integer.parseInt(d2M2Y2[1]);

		int y2 = Integer.parseInt(d2M2Y2[2]);

		int result = libraryFine(d1, m1, y1, d2, m2, y2);

		System.out.println(result);
		scanner.close();
	}
}