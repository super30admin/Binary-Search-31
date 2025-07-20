// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int diff = n - mid;
            if (diff == citations[mid]) {
                return diff;
            } else if (diff > citations[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return n - l;
    }
}