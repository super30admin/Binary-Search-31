// Time Complexity : O(log(n)),
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package binarySearch31;

/**
 *
 * @author shilpa
 */
public class HIndex_90 {

    public int hIndex(int[] citations) {
        if (citations.length == 0 || citations == null) {
            return 0;
        }
        int n = citations.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (n - mid == citations[mid]) {
                return n - mid;
            } else if (n - mid > citations[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return n - low;
    }
}
