# TC O(log n)
# SC O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # diff = n - mid == citations[mid] : return n - mid
        # if n - mid > citations[mid] low = mid + 1
        # else high = mid - 1
        n = len(citations)

        low, high = 0, n - 1
        while low <= high:
            mid = low + (high-low) // 2
            diff = n - mid
            if diff == citations[mid]:
                return diff
            elif diff > citations[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return n - low
        