// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 
// Your code here along with comments explaining your approach
class Solution {

// Time Complexity : O(n) traversing the whole array
// Space Complexity :O(1) no extra space required 
    public int hIndex(int[] citations) {
        
        if(citations==null||citations.length==0)
            return 0;
        int len=citations.length;
        for(int i=0;i<len;i++){
            if(citations[i]>=len-i)
                return len-i;
        }
        return 0;
    }

// Time Complexity : O(logn) binary search on the array
// Space Complexity :O(1) no extra space required 
    public int hIndex1(int[] citations) {
        
        if(citations==null||citations.length==0)
            return 0;
        int len=citations.length;
        int low=0;
        int high=len-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            
            if(citations[mid]==len-mid)
                return len-mid;
            else if(citations[mid]>len-mid){
                high=mid-1;
            }
            else
                low=mid+1;
        }
            return len-low;
        
    }
}