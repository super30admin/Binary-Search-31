// Time Complexity : O(m log n) where n is the number of elements in forward array and n is the number of elements in backwards array assuming that both arrays were in ascending order
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * For each entry in backwards array, finding the closest entry from forward array using binary search. If t
 */
public class Problem1 {

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        List<int[]> result = problem1.optimalRoutes(new int[][]{{1, 1000}, {2, 1500}, {3, 2500}, {4, 3000}}, new int[][]{{1, 1300}, {2, 2000}, {3, 2200}, {4, 2500}}, 5300);
        for (int[] res : result) {
            System.out.println(res[0] + " " + res[1]);
        }
    }

    private List<int[]> optimalRoutes(int[][] forward, int[][] backward, int target) {
        List<int[]> result = new ArrayList<>();

        int max = 0;

        for (int i = 0; i < backward.length; i++) {
            int complement = target - backward[i][1];
            if (complement > 0) {
                int forwardMatch = nearestForward(forward, complement);
                int sum = backward[i][1] + forward[forwardMatch][1];
                if (sum >= max) {
                    // if better match was found than before, resetting the list
                    if (sum > max)
                        result = new ArrayList<>();

                    // adding the equal or better match to the result
                    result.add(new int[]{forward[forwardMatch][0], backward[i][0]});
                    // keeping track of max so that a better or equal match can be used later
                    max = Math.max(sum, max);
                }
            }
        }

        return result;
    }

    private int nearestForward(int[][] forward, int complement) {
        int low = 0;
        int high = forward.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int[] curr = forward[mid];
            if (complement == curr[1])
                return mid;
            else if (complement > curr[1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return high;
    }
}

