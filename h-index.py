# Time Complexity: O(logn)
# Space Complexity:O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low = 0
        high = n - 1

        while low <= high:
            mid = low + (high - low) // 2
            val = n - mid
            if citations[mid] == val:
                return val
            elif citations[mid] > val:
                high = mid - 1
            else:
                low = mid + 1
        return n - low
