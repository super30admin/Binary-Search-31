
 // Time Complexity : O(log n)
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this : No


 // Your code here along with comments explaining your approach
 // Use binary search technique to find if citation at mid is equal to n-m of complement of the index
 // Otherwise we reduce the limits of our search space depending on value of citation at mid
 // At last we would return n - l, or complement of index value.

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) == 0: return 0
        n = len(citations)
        low =0
        high =n-1
        diff=0
        while(low<=high):
            mid = int(low+(high-low)/2)
            diff =n-mid
            if(citations[mid]==diff):
                return diff
            elif(citations[mid]<diff):
                low=mid +1
            else:
                high =mid-1
        return n-low
            
        