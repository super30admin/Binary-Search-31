// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return -1;
        int len = citations.length;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i)
                return len - i;
        }
        return 0;
    }
}

Approach 2
// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return -1;
        int len = citations.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] == len - mid)
                return citations[mid];
            if (citations[mid] < len - mid) {
                low = mid + 1;
            }
            if (citations[mid] > len - mid) {
                high = mid - 1;
            }

        }
        return len - low;
    }
}