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
# For eg [0,1,2,4,5] papers [5,4,3,2,1] diff = length of citations - mid as left starts from 0 or n - i as in bruteforce approach

class Solution:
    def hIndex(self, citations: list[int]) -> int:
        n = len(citations)
        if n == 0:
            return 0
        for i in range(n):
            diff = n - i
            if citations[i] >= hindex:
                return diff
            diff -= 1
        return 0
#Time - O(n)
#Space - O(1)

class Solution:
    def hIndex(self, citations: list[int]) -> int:
        n = len(citations)
        if n == 0:
            return 0
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
#Time - O(logn)
#Space - O(1)