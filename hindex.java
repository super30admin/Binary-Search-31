// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int low = 0; int high = n-1;
        while(low <= high){
            int m = low + (high - low)/2;
            int d = n- m;
            if(citations[m] == d){
                return d;
            } else if(citations[m] > d){
                high = m -1;
            }else {
                low = m +1;
            }
        }
        return n - low;
    }
}