package com.codeprep.staircase;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int maxHeight = in.nextInt();
        int secondaryHeight = 1;
        int spaceHeight = maxHeight;
        for(int i = 0; i < maxHeight; i++){
            for(int k = 1; k < spaceHeight ; k++){
                System.out.print(" ");
            }
            spaceHeight--;
            for(int j = 0; j < secondaryHeight; j++){
                System.out.print("#");
            }
            System.out.println();
            secondaryHeight++;
        }
    }

}
