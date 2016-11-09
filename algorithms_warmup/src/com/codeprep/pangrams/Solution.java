package com.codeprep.pangrams;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		HashSet<String> alphabets = new HashSet<>();
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		text = text.toLowerCase();
		char[] charArray = text.toCharArray();
		in.close();

		for (char c : charArray) {
			if (c != ' ') {
				alphabets.add(Character.toString(c));
			}
		}
		if (alphabets.size() == 26) {
			System.out.println("pangram");
		} else {
			System.out.println("not pangram");
		}
	}

}
