package interviewkit;

import java.io.IOException;
import java.util.Scanner;

public class RotLeft {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int tempA = a[0], tempB;
        int currentIndex = 0;

        for(int i = 0; i < a.length; i++){
            int targetIndex = (currentIndex + (a.length-d)) % a.length;
            tempB = a[targetIndex];
            a[targetIndex] = tempA;
            tempA = tempB;
            currentIndex = targetIndex;

            //special case, if d == a/2
            if(a.length % 2 == 0 && d == a.length/2){
                if(i%2 != 0) {
                    currentIndex++;
                    tempA = a[currentIndex];
                }
            }
        }

        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println("");

        scanner.close();
    }
}
