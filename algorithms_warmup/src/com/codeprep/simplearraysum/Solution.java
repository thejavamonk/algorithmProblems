package com.codeprep.simplearraysum;

import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int sizeOfArray = in.nextInt();
        int arr[] = new int[sizeOfArray];
        for(int arr_i=0; arr_i < sizeOfArray; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int sum = 0;
        for(int arr_i=0; arr_i < sizeOfArray; arr_i++){
            sum = sum + arr[arr_i];
        }
        System.out.println(sum);
    }

}
