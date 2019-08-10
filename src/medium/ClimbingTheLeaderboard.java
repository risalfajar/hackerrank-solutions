package medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ClimbingTheLeaderboard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        //store alice score rank
        int[] results = new int[alice.length];
        int length = scores.length;
        length = removeDuplicateElementDescending(scores, length);

        //compare Alice scores
        for(int i = 0; i < alice.length; i++){
            //find score using inverted custom binary search
            int index = modifiedBinarySearch(scores, 0, length-1, alice[i]);

            //if there's a same score in leaderboard
            if(index >= 1)
                results[i] = index + 1;
            else{
                //if result not found
                //get closest index and convert it back to positive
                index *= -1;
                //if alice score is same or more then that's her score position
                //remember that scores array is descending while results is ascending
                if(scores[index] <= alice[i])
                    results[i] = index+1;
                else
                    results[i] = index+2;
            }
        }

        return results;
    }

    //INVERTED binary search
    static int modifiedBinarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] < x)
                return modifiedBinarySearch(arr, l, mid-1, x);

            // Else the element can only be present
            // in right subarray
            return modifiedBinarySearch(arr, mid+1, r, x);
        }

        // We reach here when element is not present
        // in array
        // return closest index in negative form (to differentiate)
        return (r > 0)?r * -1:l * -1;
    }

    //remove duplicates and return new length
    static int removeDuplicateElementDescending(int[] arr, int length){
        if(length <= 1)
            return length;

        int elementBefore = arr[0];
        int elementBeforeIndex = 0;
        int newLength = 1;
        for(int i = 1; i < length; i++){
            if(arr[i] < elementBefore){
                arr[elementBeforeIndex+1] = arr[i];
                elementBefore = arr[i];
                elementBeforeIndex++;
                newLength++;
            }
        }
        return newLength;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println("\n");
            }
        }
        scanner.close();
    }
}
