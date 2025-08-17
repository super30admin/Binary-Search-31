//Bruteforce
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * n - i <= hindex and hindex >= n
*/
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        for (int i = 0; i < citations.length; i++) {
            int diff = n - i;
            if (diff <= citations[i]) {
                return diff;
            }
        }
        return 0;
    }
}

// binary search

// Bruteforce
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int diff = n - mid;

            if (citations[mid] == diff)
                return diff;
            else if (citations[mid] < diff) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return n - low;
    }
}