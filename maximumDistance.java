
// Time Complexity : O(nlog(m))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static List<int[]> maximumDistance(int[][] forward, int[][] backward, int max) {

        // to store the result
        List<int[]> result = new ArrayList<>();
        // sorting by distance
        Arrays.sort(forward, (a, b) -> a[1] - b[1]);
        Arrays.sort(backward, (a, b) -> a[1] - b[1]);
        int maxD = 0;

        for (int i = 0; i < forward.length; i++) {
            // binary search on the backward array
            int l = 0;
            int r = backward.length - 1;
            // for (int[] x : result) {
            // System.out.println("[" + x[0] + "," + x[1] + "]" + maxD);
            // }
            // System.out.println("=======");
            while (l <= r) {
                // System.out.println(result.size());
                // find mid
                int mid = l + (r - l) / 2;
                // distance of forward and backward
                int dist = forward[i][1] + backward[mid][1];
                // if distance is less than max
                if (dist <= max) {
                    // we check is it a last index on the backward or next index sum is greater then
                    // the max then we further check is it max distance
                    if (mid == backward.length - 1 || forward[i][1] + backward[mid + 1][1] > max) {
                        // if this is max distance then we reset result and add id in the result
                        if (maxD < dist) {
                            maxD = dist;
                            result = new ArrayList<>();
                            result.add(new int[] { forward[i][0], backward[mid][0] });
                        } else if (maxD == dist) {
                            // if it is equal to the maxDist we are not going to reset result we directly
                            // add id in the result
                            result.add(new int[] { forward[i][0], backward[mid][0] });
                        }
                        // break the loop
                        break;
                    } else {
                        // else we move right as we can find max distance on right side
                        l = mid + 1;
                    }
                } else {
                    // else we move left as current distance is greater than max distance so it may
                    // be possible that maximum distance we can find on the left side
                    r = mid - 1;
                }
            }
        }
        // return result;
        return result;
    }

    public static void main(String[] args) {
        int max = 7200;
        int[][] forward = new int[][] {
                { 0, 1000 },
                { 1, 1500 },
                { 2, 2500 },
                { 3, 3000 },
                { 4, 4500 },
                { 5, 6000 }
        };
        int[][] backward = new int[][] {
                { 0, 1500 },
                { 1, 2500 },
                { 2, 3000 },
                { 3, 3500 },
                { 4, 4500 },
                { 5, 5000 }
        };
        List<int[]> result = maximumDistance(forward, backward, max);
        for (int[] r : result) {
            System.out.println("[" + r[0] + "," + r[1] + "]");
        }

    }
}