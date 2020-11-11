package com.codeprep.seperatingnumbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the separateNumbers function below.
	static void separateNumbers(String s) {
        
		StringBuilder builder = new StringBuilder();
		int it = 0;
        for(int i = 1; i <= Math.round(s.length() / 2); i++){
        	it++;
            String val = s.substring(0, i);
            Long num = Long.valueOf(val);
            builder.append(val);
            while(builder.length() < s.length()){
            	num = num + 1;
            	builder.append(num);
            }
            
            if(s.equals(builder.toString())) {
            	break;
            }
            else {
            	builder.setLength(0);
            	continue;
            }
        }
        if(s.equals(builder.toString())) {
        	System.out.println("YES "+ builder.toString().substring(0, it));
        }
        else {
        	System.out.println("NO");
        }
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			separateNumbers(s);
		}

		scanner.close();
	}
}