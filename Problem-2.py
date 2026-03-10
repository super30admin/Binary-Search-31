# Time Complexity : O(log n), n = length of citations
# Space Complexity : O(1), only a few variables used
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use binary search to find the smallest index where citations[i] >= n - i.
# 2. n - i gives the number of papers with at least citations[i] citations.
# 3. Return n - left as the h-index.

from typing import List

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        left, right = 0, n - 1
        
        while left <= right:
            mid = (left + right) // 2
            if citations[mid] >= n - mid:
                # mid may be the h-index, search left for smaller index
                right = mid - 1
            else:
                # Not enough citations, search right
                left = mid + 1
        
        # n - left is the maximum h-index
        return n - left