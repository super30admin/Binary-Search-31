// Problem Amazon | OA 2019 | Optimal Utilization
// Time Complexity : O(mlogm + nlogn)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class FindOptimalPairs{
    public List<int[]> findOptimalPairs(List<int[]> a, List<int[]> b, int target) {
        // Sort both lists based on the second element (value)
        Collections.sort(a, (x, y) -> x[1] - y[1]);
        Collections.sort(b, (x, y) -> x[1] - y[1]);
        List<int[]> result = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        int i = 0;  // Pointer for list a
        int j = b.size() - 1;  // Pointer for list b
        // Two-pointer technique
        while (i < a.size() && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if (sum <= target) {
                // If this sum is better (closer to target), update maxSum and clear result
                if (sum > maxSum) {
                    result.clear();
                    maxSum = sum;
                }
                // If this sum equals the current max sum, add this pair
                if (sum == maxSum) {
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                }

                // Move the pointer in list `a` to explore more combinations
                i++;
            } else {
                // If the sum is greater than the target, move the pointer in list `b` to reduce the sum
                j--;
            }
        }
        return result;
    }
}