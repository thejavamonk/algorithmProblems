package com.codeprep.candies;

import java.util.ArrayList;
import java.util.List;

/* Alice is a kindergarden teacher. She wants to give some candies to the children in her class.  
 * All the children sit in a line ( their positions are fixed), and each  of them has a rating 
 * score according to his or her performance in the class.  Alice wants to give at least 1 candy 
 * to each child. If two children sit next to each other, then the one with the higher rating 
 * must get more candies. Alice wants to save money, so she needs to minimize the total number 
 * of candies given to the children.

Input Format

The first line of the input is an integer N, the number of children in Alice's class. Each of the 
following N lines contains an integer that indicates the rating of each child.

1 <= N <= 105
1 <= rating <= 105

Output Format

Output a single line containing the minimum number of candies Alice must buy. */

public class Solution {

	static long numberOfStudents;
	static long average;
	static long[] scores;

	public static void main(long[] args) {

		numberOfStudents = args[0];
		Student student = new Student();

		for (int i = 1, j = 0; i < args.length; i++, j++) {
			scores[j] = args[i];
		}

		long lastRank = scores[scores.length + 1];
		int numberOfChoclatesToFirst = (int) lastRank;
		List<Student> students = new ArrayList<>();

		for (int i = 0; i < scores.length; i++) {

			student.setScore(scores[i]);
			students.add(student);
		}

		boolean isFirstValue = true;
		long lastScore = 0;

		for (int i = 0, numberOfChocolates = numberOfChoclatesToFirst; i < students.size(); i++) {

			if (isFirstValue) {
				students.get(i).setChocolates(numberOfChocolates);
				numberOfChocolates--;
			} else {
				if (lastScore != 0 && lastScore == students.get(i).getScore()) {

				} else {
					students.get(i).setChocolates(numberOfChocolates);
					numberOfChocolates--;
				}
			}
			lastScore = students.get(i).getScore();
		}

		long lastScoreValue = 0;
		boolean isFirstScoreValue = true;

		for (int i = 0; i < students.size(); i++) {

			if (isFirstScoreValue) {
				lastScoreValue = students.get(i).getScore();
			} else {

				if (lastScoreValue == students.get(i + 1).getScore()) {
					students.get(i + 1).setChocolates(students.get(i).getChocolates());
				}
			}
			lastScoreValue = students.get(i).getScore();
		}

		long numberOfChocolates = 0;

		for (int i = 0; i < students.size(); i++) {
			numberOfChocolates = numberOfChocolates + students.get(i).getChocolates();
		}
		System.out.println(numberOfChocolates);
	}
}

class Student {
	private long score;
	private long chocolates;

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public long getChocolates() {
		return chocolates;
	}

	public void setChocolates(long chocolates) {
		this.chocolates = chocolates;
	}
}
