// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.
package Binary-Search-3.1;

public class Problem-2 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low= 0, high = n-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            int dif = n - mid;
            if(dif == citations[mid]){
                return dif;
            //goal is to make dif equal to citation, so binary search moves to the half where there is a possibility of becoming equal.
            }else if(dif > citations[mid]){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return n - low;
    }
}
