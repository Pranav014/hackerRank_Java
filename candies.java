import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int dp[] = new int[n+1];
        int leftcandies[] = new int[n];
        int rightcandies[] = new int[n];
        for(int i=0;i<n;i++){
            leftcandies[i] = 1;
            rightcandies[i] = 1;
            dp[i] = 1;
        }
        
        for(int i=0;i<n-1;i++){
            //System.out.println(arr[i]);
            if(arr[i+1]>arr[i]){
                leftcandies[i+1] = leftcandies[i] +1;
               // dp[i+1] = dp[i+1] + dp[i] +1;
            }
           
        }
        for(int i=n-1;i>=1;i--){
            if(arr[i-1]>arr[i]){
                rightcandies[i-1] = rightcandies[i] +1;
               // dp[i+1] = dp[i+1] + dp[i] +1;
            }
        }
        long sum = 0;
        for(int i=0;i<n;i++){
            //System.out.println(candies[i]);
            sum = sum+ Math.max(leftcandies[i],rightcandies[i]);
        }
        return sum;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
