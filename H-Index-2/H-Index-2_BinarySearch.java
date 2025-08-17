/* Time Complexity : O(log n) 
*   n - length of array - arr - citations*/
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Binary Search solution

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0; 
        int high = n - 1;
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
        return n - low;
    }
}