package com.risal.risal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalGrade = new ArrayList<>();

        for(int grade:grades){
            if(grade >= 38){
                finalGrade.add(round(grade));
            }else{
                finalGrade.add(grade);
            }
        }

        return finalGrade;
    }

    static int round(int num){
        int mod = num % 5;

        if(mod < 3){
            return num;
        }else{
            return num + 5 - mod;
        }
    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < gradesCount; i++) {
            int gradesItem = Integer.parseInt(bufferedReader.readLine().trim());
            grades.add(gradesItem);
        }

        List<Integer> result = Result.gradingStudents(grades);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));

            if (i != result.size() - 1) {
                System.out.println("\n");
            }
        }
    }
}
