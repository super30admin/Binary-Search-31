// 275. H-Index II - https://leetcode.com/problems/h-index-ii/
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {

        if(citations==null||citations.length==0)
            return 0;

        int n=citations.length;
        int low=0;
        int high=n-1;

        while(low<=high)
        {
            int mid=low + (high-low)/2;

            if(citations[mid]==(n-mid))
                return n-mid;
            else if(citations[mid]<(n-mid))
                low=mid+1;
            else
                high=mid-1;
        }
        return n-low;
    }
} 