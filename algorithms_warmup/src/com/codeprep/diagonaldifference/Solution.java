package com.codeprep.diagonaldifference;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int sizeOfMatrix = in.nextInt();
        int a[][] = new int[sizeOfMatrix][sizeOfMatrix];
        for(int a_i=0; a_i < sizeOfMatrix; a_i++){
            for(int a_j=0; a_j < sizeOfMatrix; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int sumOfRight = 0;
        int sumOfLeft = 0;
        
        for(int i =0; i < sizeOfMatrix; i++){
            sumOfRight = sumOfRight + a[i][i];
        }
        for(int i =0, j = sizeOfMatrix - 1; i <sizeOfMatrix; i++, j--){
            sumOfLeft = sumOfLeft + a[j][i];
        }
        int sum = sumOfRight - sumOfLeft;
        System.out.println(sum);
    }
}
