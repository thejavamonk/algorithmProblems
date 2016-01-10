package com.codeprep.timeconversion;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        StringBuilder solution = new StringBuilder();
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String[] strings = time.split(":");
        if (time.contains("PM")) {
            String twelvePMCase = strings[0];
            int twelvePMCaseInt = 0;
            if(Integer.parseInt(twelvePMCase) < 12){
                twelvePMCaseInt = Integer.parseInt(twelvePMCase) + 12;
            }else{
                twelvePMCaseInt = Integer.parseInt(twelvePMCase);
            }
            solution.append(twelvePMCaseInt).append(":" + strings[1])
                    .append(":" + strings[2].replace("PM", " "));
        } else {
            String twelveAMCase = strings[0];
            if(strings[0].equalsIgnoreCase("12")){
                twelveAMCase = "00";
            }
            solution.append(twelveAMCase).append(":" + strings[1])
            .append(":" + strings[2].replace("AM", " "));
        }
        System.out.println(solution.toString());
    }

}
