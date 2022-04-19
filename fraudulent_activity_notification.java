import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
 private static final int MAX_EXPENDITURE = 200;
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] a, int d) {
       int ans = 0;
        int[] histogram = new int[MAX_EXPENDITURE + 1];
 
        // Carry a histogram of the last d expenditures
        for (int i = 0; i < d; i++) {
            histogram[a[i]] = histogram[a[i]] + 1;
        }
 
        for (int i = d; i < a.length; i++) {
            int cursor = 0;
            int currentAmount = a[i];
            double median = 0;
            int left = -1;
            int right = -1;
            for (int e = 0; e <= MAX_EXPENDITURE; e++) {
                cursor += histogram[e];
                if (d % 2 == 1) {
                    // Odd -> Pick middle one for median
                    if (cursor >= d / 2 + 1) {
                        median = e;
                        break;
                    }
                } else {
                    // Even -> Pick average of two middle values for median
                    if (cursor == d / 2) {
                        left = e;
                    }
 
                    if (cursor > d / 2 && left != -1) {
                        right = e;
                        median = (left + right) / 2.0;
                        break;
                    }
 
                    if (cursor > d / 2 && left == -1) {
                        median = e;
                        break;
                    }
                }
 
            }
 
            if (currentAmount >= 2 * median) {
                ans++;
            }
 
            // Update histogram: slide window 1 index to right
            histogram[a[i - d]] = histogram[a[i - d]] - 1;
            histogram[a[i]] = histogram[a[i]] + 1;
        }
 
 
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
