package problems.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//TC=O(nlogn)
//SC=O(1)
public class Problem90 {
    public List<List<Integer>> sumPairs(int[][] depart, int[][] arrival, int target) {
        Arrays.sort(arrival, (x, y) -> Integer.compare(x[1], y[1]));

        int bestSum = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < depart.length; i++) {
            int complementValue = target - depart[i][1];
            int bsIndex = binarySearch(arrival, complementValue);

            if (bsIndex != -1) {
                int currentSum = depart[i][1] + arrival[bsIndex][1];
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    result.clear();
                    List<Integer> subRoute=new ArrayList<>();
                    subRoute.add(depart[i][0]);
                    subRoute.add(arrival[bsIndex][0]);
                    result.add(subRoute);
                } else if (currentSum == bestSum) {
                    List<Integer> subRoute=new ArrayList<>();
                    subRoute.add(depart[i][0]);
                    subRoute.add(arrival[bsIndex][0]);
                    result.add(subRoute);
                }
            }
        }
        return result;
    }

    private static int binarySearch(int[][] num, int target) {
        int low = 0;
        int high = num.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (num[mid][1] == target) {
                return mid;
            } else if (num[mid][1] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[][] depart = {{1, 500}, {2, 1000}, {3, 2500},{4, 3000},{5, 3500},{6, 4500}};
        int[][] arrival = {{1, 1000}, {2, 1500}, {3, 2500},{4, 4500},{5, 6800},{6, 7000}};
        Problem90 problem=new Problem90();
        System.out.println(problem.sumPairs(depart, arrival, 7000));  // Output: [2, 5]
    }

}
