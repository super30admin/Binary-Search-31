class Solution {
    public int hIndex(int[] citations) {
        int index = -1;
        int left = 0;
        int right = citations.length-1;
        int len = citations.length;
        while(left <= right) {
            int mid = left + ( ( right -  left) /2);
            
            if(citations[mid] == len - mid) {
                return len - mid;
            }    else if(citations[mid] < len - mid ) {
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return len - left;
        
        
    }
}

//
// time complexity : O(logn)
