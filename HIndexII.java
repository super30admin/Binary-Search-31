/**
 * Uses binary search on the sorted citations array to find the smallest index where citations[i] >= n - i.
 * This ensures at least (n - i) papers have ≥ (n - i) citations, satisfying H-index definition.
 * Returns n - left after search completes, which represents the maximum valid H-index.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}
