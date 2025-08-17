// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int low = 0;
        int high = len -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int diff = len - mid;
            if(citations[mid] ==diff) return diff;
            else if(citations[mid] > diff){
                high = mid - 1;
            }
            else{
                low = mid +1;
            }
        }
        return len - low;
    }
}
