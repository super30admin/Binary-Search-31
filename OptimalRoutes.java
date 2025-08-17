// time complexity - O(logn)
// space complexity - O(1)
// did you face any issues - no
// using two pointer approach to find the closed sum for target
import java.util.*;

public class ClosestPairSum {
    public static List<int[]> findClosestPairs(int[][] arr1, int[][] arr2, int target) {
        List<int[]> result = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        int i = 0, j = arr2.length - 1;

        while (i < arr1.length && j >= 0) {
            int sum = arr1[i][1] + arr2[j][1];

            if (sum > target) {
                j--;  // Decrease sum
            } else {
                if (sum > maxSum) {
                    result.clear();
                    result.add(new int[]{arr1[i][0], arr2[j][0]});
                    maxSum = sum;
                } else if (sum == maxSum) {
                    result.add(new int[]{arr1[i][0], arr2[j][0]});
                }
                i++;  // Try next larger value from arr1
            }
        }

        return result;
    }
