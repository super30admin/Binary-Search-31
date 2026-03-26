// Time Complexity : O(m log m + n log m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to first sort the min length array first depending upon the distances. Next, make a linear traversal
on the forward array and perform the binary search in the backward array with target as the difference of target
and incoming forward array element similar to 2Sum problem.If we find an index, we add the respective distances
and check if its greater than or equal to local max distance and make it max by adding the respective ids'
to the result.
 */
class Solution {
    public List<int[]> optimalAirRoute(int[][] forward, int[][] backward, int target) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(backward, (a, b) -> (a[1] - b[1]));
        int max = 0;

        for(int[] pair : forward) {
            int index = binarySearch(backward, target - pair[1]);
            if(index != -1) {
                int sum = pair[1] + backward[index][1];
                if(sum >= max) {
                    max = sum;
                    result.add(new int[] {pair[0], backward[index][0]});
                }
            }
        }
        return result;
    }

    private int binarySearch(int[][] backward, int target) {
        int low = 0, high = backward.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(backward[mid][1] == target)
                return mid;
            else if(backward[mid][1] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] forward = {{1, 2000}, {2, 3000}, {3, 4000}};
        int[][] backward = {{1, 5000}, {2, 3000}};
        int target = 5000;
        List<int[]> res = s.optimalAirRoute(forward, backward, target);
        for (int[] pair : res) {
            System.out.println(pair[0] + "," + pair[1]);
        }
    }
}
