# Time Complexity : O(logn) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach: This code computes the h-index from a sorted citations list using binary search. At each step, it checks if the number of papers with at least citations[mid] citations (n - mid) matches the current citation count. If not, it adjusts the search range until it finds the correct position, and finally returns n - low as the h-index.

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)

        low, high = 0, n - 1

        while low <= high:
            mid = low + (high - low) // 2
            diff = n - mid

            if diff == citations[mid]:
                return diff

            elif diff > citations[mid]:
                low = mid + 1
            
            else:
                high = mid - 1
        
        return n - low