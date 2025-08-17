//time - O(logn)
//space - O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low =0 ;
        int high = n-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            int diff = n - mid;
            if(citations[mid] == diff)
                return diff;
            else if(citations[mid] > diff){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return n-low;
    }
}


/*
[0,1,3,5,6]  -> BS





*/