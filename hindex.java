
// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Brute force would be O(N^2) to see if each index is hindex
// next would be O(N) where we take the h<=h and find the h index if its eqaual or lesser
// this O(N) can be converted to Binsearch to again find the same h index if its equal or lesser
public class hindex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int diff = n - mid;

            if (diff == citations[mid]) {
                return diff;
            } else if (diff > citations[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return n - low;

        /*
        for (int i = 0; i < n; i++) {
            int diff = n - i;

            if (diff <= citations[i]) {
                return diff;
            }
        }

        return 0;
        */
    }
}