// Time Complexity: O(log(n))
// Space Complexity: O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n - 1;

        // Binary search to find the h-index
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If the citations at mid are enough for the h-index
            if (citations[mid] >= n - mid) {
                high = mid - 1;  // Move to the left half
            } else {
                low = mid + 1;   // Move to the right half
            }
        }

        // The h-index is the number of papers with citations >= h
        return n - low;
    }
}
