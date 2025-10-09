// Time Complexity : O(log n) where n is the number of papers
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using binary search to find the number of papers where the number of citations are greater or equals to number of papers.
 */
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n -1;

        while (low <= high) {
            int mid = low + (high - low) /2;
            int diff = n - mid;
            if (diff == citations[mid]) {
                return diff;
            } else if (diff > citations[mid]) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }

        return n - low;

    }
}