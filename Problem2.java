// Time Complexity : O(log n) where n is the size of of citations array
// Space Complexity : O(1) constant space as we did not use any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Problem2 {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int n = citations.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(citations[mid] >= n - mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return n - low;
    }
}
