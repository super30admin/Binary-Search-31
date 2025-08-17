// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
  public int hIndex(int[] citations) {
    int n = citations.length;
    // Edge case
    if(citations == null || n == 0) return 0;
    int low = 0;
    int high = n-1;
    while(low<=high) {
      int mid = low + (high - low)/2;
      if(citations[mid] >= n - mid) {
        // Maximising the h-index
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return n-low;
  }
}