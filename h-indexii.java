// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0 || citations==null){
            return 0;
        }
        int low = 0;
        int high = citations.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int h = citations.length - mid;
            if(citations[mid]==h){
                return h;
            }else if(citations[mid]>h){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return citations.length-low;
    }
}