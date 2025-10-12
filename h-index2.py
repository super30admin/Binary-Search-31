# Time Complexity : O(log n) where n is the number of nodes in the binary tree
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using binary search to find the h-index. I will keep track of the low and high pointers.
# I will calculate the mid index and the difference between the length of the citations array and the mid index.
# If the difference is equal to the citations at the mid index, then I have found the h-index and I will return the difference.
# If the difference is greater than the citations at the mid index, then I will move the low pointer to mid + 1.
# If the difference is less than the citations at the mid index, then I will move the high pointer to mid - 1.
# I will continue this process until the low pointer is greater than the high pointer.
# If I do not find the h-index, then I will return the length of the citations array minus the low pointer.

from typing import List
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low = 0
        high = n - 1
        while low <= high:
            mid = low + (high - low) //2 
            diff = n - mid
            if diff == citations[mid]:
                return diff
            elif diff > citations[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return n - low
        