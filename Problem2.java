// Time Complexity : O(n log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/* The H index is the point where the difference between n and i is same or where the difference is greater than the element at i position. 
Run a binary search and if the difference between n and mid is same, return the diff as H index, else 
 * if difference is greater, change low to mid+1, else h to mid -1;
 *
 */
class Problem2 {
    public int hIndex(int[] citations){
        int n = citations.length;
        int l = 0; 
        int h = n - 1; 
        while(l <= h){
            int mid = l + (h-l)/2;
            int diff = n - mid; 
            if(citations[mid] == diff)
                return diff;
            else if(citations[mid] > diff)
                h = mid - 1; 
            else 
                l = mid + 1;
        }
        return n - l;
    }
}