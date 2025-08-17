// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {

        int len = citations.length;

        for(int i=0;i<len;i++){

            //Hindex
            if(citations[i] >= len-i){
                return len-i;
            }
        }

        return 0;

    }
}