//*****H-INDEX-2: LINEAR SEARCH
//Time complexity: 0(n);
//Space complexity:0(1);
//Leetcode runnable: Y;


class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0 || citations==null)
        {
            return 0;
        }
        int n=citations.length;
        
        for(int i=0;i<n;i++)
        {
            int diff=n-i;
            if(diff<=citations[i])
            {
                return diff;
            }
        }
        return 0;
    }
}
//*****H-INDEX-2: BINARY SEARCH
//Time complexity: 0(n);
//Space complexity:0(1);
//Leetcode runnable: Y;

class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0 || citations==null)
        {
            return 0;
        }
        int n=citations.length;
        
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(citations[mid]==n-mid)
            {
                return n-mid;
            }
        }
        return 0;
    }
}
