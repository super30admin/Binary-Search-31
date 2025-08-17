# Linear Solution
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations) == 0:
            return 0
        n = len(citations)
        for i in range(n):
            diff = n - i
            if citations[i] >= diff:
                return diff
        return 0

# Time Complexity: O(n)
# Space Complexity: O(1)

# Binary Search Solution
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations) == 0:
            return 0
        n = len(citations)
        low = 0
        high = n - 1
        while low <= high:
            mid = low + (high - low) // 2
            if citations[mid] == n - mid:
                return n - mid
            elif citations[mid] < n - mid:
                low = mid + 1
            else:
                high = mid - 1
        return n - low
# Time Complexity: O(log(n))
# Space Complexity: O(1)


