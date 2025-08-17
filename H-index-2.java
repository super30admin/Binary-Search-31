// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int l = 0;
        int r = citations.length-1 ;
        while(l<=r){
            int m = l + (r - l) /2; // prevnt integer overflow
            if(citations[m] >= citations.length - m){
                r = m - 1;
            } 
            else{
                l = m + 1; 
            }
        }
        return citations.length - l;
    }
}