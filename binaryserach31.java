import java.util.*;
public class Main {
    public static List<List<Integer>> optimalPairs(int[][] a, int[][] b, int target) {
        Arrays.sort(a, (x, y) -> Integer.compare(x[1], y[1]));
        Arrays.sort(b, (x, y) -> Integer.compare(x[1], y[1]));
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int j = b.length - 1;
        int maxSum = Integer.MIN_VALUE;
        while (i < a.length && j >= 0) {
            int sum = a[i][1] + b[j][1];
            if (sum > target) {
                j--;
            } else {
                if (sum >= maxSum) {
                    if (sum > maxSum) {
                        maxSum = sum;
                        ans.clear();
                    }
                    int k = j;
                    while (k >= 0 && b[k][1] == b[j][1]) {
                        ans.add(Arrays.asList(a[i][0], b[k][0]));
                        k--;
                    }
                }

                i++;
            }
        }

        return ans;
    }
