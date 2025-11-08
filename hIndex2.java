// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// citations.length - mid gives the number of papers with at least citations[mid] citations
// With binary search we try to find the point where there are atleast citations[mid] papers with citations[mid] citations (citations[mid] == citations.length - mid )
// Try to find the point where the difference between citations[mid] and citations.length - mid switches

class Solution {
    public int hIndex(int[] citations) {
        int l = 0; int h = citations.length - 1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(citations[mid] == citations.length - mid )
                return citations.length - mid;
            else if ( citations[mid] > citations.length - mid)
                h = mid -1;
            else
                l = mid +1;
        }

        return citations.length - l;
    }
}