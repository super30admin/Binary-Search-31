// Time complexity = O(log(n))
// space complexity = O(1).

// we are doing a binary search on the citations array
// if the citations value is equal to no. of papers we have hit the jackpot.
// else we need to do a binary search
class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int low =0;
        int high = length-1;
        while(low<= high) {
            int mid = low + (high-low)/2;
            if(citations[mid] == length- mid) {
                return length-mid;
            } else if(citations[mid] < length- mid) { // no. of papers is greater than the citations values then go right
                low = mid+1;
            } else { // go left.
                high = mid-1;
            }
        }
        return length-low;
        
    }
}