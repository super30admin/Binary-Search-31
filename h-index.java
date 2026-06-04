// Time Complexity : O(log n) because we use Binary Search on the sorted citations array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use Binary Search to find the point where the number of papers on the right equals the citation count.
// For any index mid, n - mid represents the number of papers having at least citations[mid] citations.
// If an exact match is not found, n - low gives the maximum valid H-index.

class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;

        int low = 0;
        int high = n - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            // number of papers with at least citations[mid] citations
            int diff = n - mid;

            if(citations[mid] == diff) {
                return diff;
            }

            if(diff > citations[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return n - low;
    }
}