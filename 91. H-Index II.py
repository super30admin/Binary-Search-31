# Binary Search solution
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        n = len(citations)
        low = 0
        high = n - 1

        while low <= high:
            mid = low + (high - low) // 2
            if citations[mid] == n - mid:
                return n - mid
            elif citations[mid] > n - mid:
                high = mid - 1
            else:
                low = mid + 1
        return n - low

# two pointer Solution
# Time complexity : O(N)
# Space complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
