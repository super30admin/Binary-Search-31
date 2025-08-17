
// Time Complexity : O(log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Binary Search
 */
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == n - mid)
                return citations[mid];
            if (citations[mid] < n - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return n - left;
    }
}



