// Time Complexity : O(log n)
// Space Complexity : O(1)

class Solution {
    public int hIndex(int[] citations) {
        int l = 0;
        int h = citations.length - 1;
        int n = citations.length;
        while(l <= h){
            int m = l + (h - l) / 2;
            if(n - m == citations[m])
                return n - m;
            else if(n - m > citations[m])
                l = m + 1;
            else
                h = m - 1;
        }
        
        return n - l;
    }
}