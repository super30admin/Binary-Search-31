# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Binary Search. Get the mid by left and right pointers
# Get the difference by length of citations  - mid
# Check if the diff is equal to citations at index mid return difference
# Else if the diff is greater than citations at index mid then increment the left pointer to mid + 1
# Else decrement the right pointer to mid - 1
# Return length of citations - left


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        n = len(citations)
        left = 0
        right = n - 1
        while left <= right:
            mid = left + (right - left) // 2
            diff = n - mid
            if diff == citations[mid]:
                return diff
            elif diff > citations[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return n - left