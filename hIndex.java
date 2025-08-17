class Solution {
    public int hIndex(int[] citations) {
        
        int n=citations.length;
        int l=0;
        int h=citations.length-1;
        
        while(l<=h)
        {
            int m=l+(h-l)/2;
            
            if(citations[m]==n-m)
                return n-m;
            else if(citations[m]>n-m)
                h=m-1;
            else
                l=m+1;
        }
        
        return n-l;
    }
}

// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no