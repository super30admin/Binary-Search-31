// Problem 275. H-Index II
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if the current number of citations is enough for h-index
            if (citations[mid] >= n - mid) {
                right = mid - 1; // Try for a higher h-index on the left side
            } else {
                left = mid + 1; // The mid value is too small, so search right
            }
        }
        return n - left; // `n - left` gives the h-index
    }
}
