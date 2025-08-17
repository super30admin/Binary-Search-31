/*
 * TC: O(logn), n: citations.length
 * SC: O(1)
 * 
 * Approach: I will perform binary search on the length of the citations[]. at each iteratin i will calculate the diff, which is citations.length-mid. If i get the diff = citations[mid], here i can directly return the diff.If not, i will keep reducing my search space by updating low and high according to thr 
 * value of diff.After the while loop is terminated, i will return the diff of the total length and the low pointer.
 */
class Solution {
    public int hIndex(int[] citations) {
        int res;
        int len = citations.length;
        int low = 0, high = len-1;

        while(low <=high){
            int mid = low+ (high-low)/2;
            int diff = len - mid;

            if(diff == citations[mid]) return diff;
            else if(diff < citations[mid]) high = mid-1;
            else low = mid + 1;
        }
    return len - low;    
    }
}