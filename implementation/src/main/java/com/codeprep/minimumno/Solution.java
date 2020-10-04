package com.codeprep.minimumno;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	// Complete the minimumNumber function below.
	static int minimumNumber(int n, String password) {

		int count = 0;
		
		Pattern patternDigit = Pattern.compile("(\\d)");
		Pattern patternUpper = Pattern.compile("([A-Z])");
		Pattern patternLower = Pattern.compile("([a-z])");
		Pattern patternSpecial = Pattern.compile("(\\W)");
        
		Matcher matcherDigit = patternDigit.matcher(password);
		Matcher matcherUpper = patternUpper.matcher(password);
		Matcher matcherLower = patternLower.matcher(password);
		Matcher matcherSpecial = patternSpecial.matcher(password);
		
		if (!matcherDigit.find()) {
			count++;
		}
		if (!matcherUpper.find()) {
			count++;
		}
		if (!matcherLower.find()) {
			count++;
		}
		if (!matcherSpecial.find()) {
			count++;
		}
		if ((count+password.length())<6) {
			count = count + 6-(count+password.length());
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String password = scanner.nextLine();

		int answer = minimumNumber(n, password);

		System.out.println(String.valueOf(answer));
		scanner.close();
	}
}
