# Binary Search
""""// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low = 0
        high = n - 1
        while low <= high:

            mid = low + (high - low) // 2
            diff = n - mid
            if citations[mid] == diff:
                return diff
            elif citations[mid] < diff:
                low = mid + 1
            else:
                high = mid - 1
        return n - low
""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         n=len(citations)
#         if n==0 or not citations:
#             return 0
#         for i in range(n):
#             diff=n-i
#             if diff<=citations[i]:
#                 return diff
#         return 0
