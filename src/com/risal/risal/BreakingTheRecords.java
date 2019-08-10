package com.risal.risal;

import java.io.IOException;
import java.util.Scanner;

public class BreakingTheRecords {
    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int[] result = {0, 0};

        int min = scores[0], max = scores[0];
        for(int i = 1; i < scores.length; i++){
            if(scores[i] > max) {
                max = scores[i];
                result[0]++;
            }
            else if(scores[i] < min) {
                min = scores[i];
                result[1]++;
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println(" ");
            }
        }

        scanner.close();
    }
}
