
// In this problem we are trying to get the number of papers that have atleast citations[i] citations by doing n-i. So, in binary
// search we are doing n-mid, and checking if computations[mid]>=n-mid, that means there is a chance of getting higher h-index,
// on left side, else moving right

// Time Complexity: O(logn)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int hIndex(int[] citations) {
        // Base case
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int low = 0;
        int high = n - 1;
        // low<=high
        while (low <= high) {
            // compute mid
            int mid = low + (high - low) / 2;
            // check if citations recieved for paper at index mid are greater than or equal
            // to n-mid
            if (citations[mid] >= n - mid) {
                // move left
                high = mid - 1;
            } else {
                // move right
                low = mid + 1;
            }
        }
        // low will be positioned correctly so n-low
        return n - low;
    }
}