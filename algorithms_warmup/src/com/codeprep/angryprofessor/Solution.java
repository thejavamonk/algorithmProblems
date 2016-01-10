package com.codeprep.angryprofessor;

import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for(int a0 = 0; a0 < testCases; a0++){
            int numberOfStudents = in.nextInt();
            int minimumNumberOfStudents = in.nextInt();
            int [] arrivalTimes = new int[numberOfStudents];
            for(int a_i=0; a_i < numberOfStudents; a_i++){
                arrivalTimes[a_i] = in.nextInt();
            }
            
            checkArrivals(arrivalTimes, minimumNumberOfStudents);
        }
    }
    
    public static void checkArrivals(int [] arrivalTimes, int minimumStudents){
        int numberOfStudentsOnTime = 0;
        for(int i =0; i < arrivalTimes.length; i++){
            if(arrivalTimes[i] <= 0){
                numberOfStudentsOnTime++;
            }
        }
        if(numberOfStudentsOnTime >= minimumStudents){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }

}
