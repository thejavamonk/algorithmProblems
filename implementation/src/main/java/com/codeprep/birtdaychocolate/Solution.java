package com.codeprep.birtdaychocolate;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {

        int possibleCombinations = 0;

        for(int i = 0; i < s.size(); i++){
            int sum = 0;
            List<Integer> bar = new ArrayList<>(m);
            if(m + i <= s.size()){
            	int nextVal = i + m;
                for(int p = i; p < nextVal; p++){
                    bar.add(s.get(p));
                    sum = sum + s.get(p);
                }
            }
            if(sum == d && bar.size() == m){
                possibleCombinations++;
            }
        }
        return possibleCombinations;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        @SuppressWarnings("unused")
		int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

       System.out.println(result);
        bufferedReader.close();
    }
}

