class Solution {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach 1 - Brute force
    public int hIndex(int[] citations) {
        int n = citations.length;
        for(int i = 0; i < n; i++) {
            int diff = n-i;
            if(citations[i] >= diff) {
                return diff;
            }
        }
        return 0;
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 1 - Binary Search
class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        //if(len == 1) return 1;
        int low = 0;
        int high = len-1;

        while(low <= high) {
            int mid = low + (high-low)/2;
            int diff = len-mid;

            if(citations[mid] == diff) {
                return diff;
            } else if(citations[mid] < diff) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return len-low;
    }
}