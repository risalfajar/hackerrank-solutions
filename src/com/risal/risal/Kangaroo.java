package com.risal.risal;

import java.io.IOException;
import java.util.Scanner;

public class Kangaroo {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(x1 > x2){
            if(v2 > v1)
                return ((x1-x2) % (v2-v1) == 0)?"YES":"NO";
        }else{
            if(v1 > v2)
                return ((x1-x2) % (v2-v1) == 0)?"YES":"NO";
        }

        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);

        scanner.close();
    }
}
