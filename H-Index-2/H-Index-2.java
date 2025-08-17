/* Time Complexity : O(n) 
*   n - length of array - arr - citations*/
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        for(int i = 0; i < n; i++){
            int diff = n - i;
            if(citations[i] >= diff){
                return diff;
            }
        }
        return 0;
    }
}