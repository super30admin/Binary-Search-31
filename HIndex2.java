// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use binary search technique to find if citation at mid is equal to n-m of complement of the index
// Otherwise we reduce the limits of our search space depending on value of citation at mid
// At last we would return n - l, or complement of index value. 

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        while(l <= r){
            int mid =  l + (r - l) / 2;
            if(citations[mid] == n-mid)
                return n-mid;
            if(citations[mid] < n - mid)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return n - l;
    }
}