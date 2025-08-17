// T O(n)
// S O(1)
class Solution {
    public int hIndex(int[] citations) {
     
        int n= citations.length;
        int diff= n;
        for(int i=0;i<citations.length;i++)
        {
            diff=n-i;
            
            if(diff<=citations[i])
                return diff;
        }
        return 0;
    }
}