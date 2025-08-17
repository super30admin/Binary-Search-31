// time complexity - O(logn)
// space complexity - O(1)
// solved on leetcode - yes
// did you face any issues - no
// The approach here is to keep seraching for the sub-array with no more than h citation each, as we do       your normal binary search, at every mid index we check if the value at mid is less than len of arr - mid      index, so we know that non h citation elements are towards left of the mid, so we move our low towards right      like this we keep on doing this until low and high cross each other, and later once the low crosses the      mid we return length of the array - low.

class Solution {
    public int hIndex(int[] citations) {
        int low =0, high =citations.length-1, n =citations.length;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(citations[mid] == n-mid) {
                return n-mid;
            } else if(citations[mid] <= n-mid) {
                low =mid+1;
            } else {
                high = mid-1;
            }
        }
        return n-low;
    }
}
