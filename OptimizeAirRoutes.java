/**
 * Brute force approach: iterate over all forward and return route pairs and track the maximum sum <= target.
 * If a better sum is found, reset the result; if equal to current max, add the pair.
 * Returns all pairs of route IDs that achieve the optimal utilization of the aircraft.
 *
 * Time Complexity: O(F * R)
 * Space Complexity: O(k) where k is number of optimal pairs
 */

public class Solution {
    public List<int[]> optimalAirRoute(int[][] forward, int[][] backward, int target) {
        List<int[]> result = new ArrayList<>();
        int max = 0;

        for (int[] f : forward) {
            for (int[] b : backward) {
                int sum = f[1] + b[1];
                if (sum <= target) {
                    if (sum > max) {
                        max = sum;
                        result = new ArrayList<>();
                        result.add(new int[]{f[0], b[0]});
                    } else if (sum == max) {
                        result.add(new int[]{f[0], b[0]});
                    }
                }
            }
        }

        return result;
    }
}
