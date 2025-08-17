/* Time Complexity : O(logn)
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // loop through all the citations
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            // mid element
            int mid = l + (r - l) / 2;
            // diffrence of number of citations greater then at mid index
            int diff = n - mid;
            // if diff is equal to the number of citatation at particular index we
            // return diffrence
            if (diff == citations[mid]) {
                return diff;
            } else if (diff > citations[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // if w didn't find an exact match
        return n - l;
    }
}