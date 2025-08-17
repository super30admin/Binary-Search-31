// ## Problem2
// H-Index II (https://leetcode.com/problems/h-index-ii)

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int n = citations.length;
        int low = 0;
        int high = citations.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int diff = n - mid;
            if(citations[mid] == diff){
                return diff;
            }else if(citations[mid] > diff){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return n-low;
    }
}