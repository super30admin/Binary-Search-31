// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use a binary search approach to check if our mid element's citation value gets equal to the number of papers
from that point to the end.If so, we got the h-index.If the mid index citation is less than the comparison, it
means there are more number of papers than the current citation count can support for h-index.We need to move to
the right half.If not, we move to the left half.If no match is found post the loop, it means our h-index lies
in the n-lowth index.
 */
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(citations[mid] == n - mid)
                return citations[mid];
            else if(citations[mid] < n - mid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return n - low;
    }
}