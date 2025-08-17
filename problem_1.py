# Time Complexity - O(logn)
# Space Complexity - O(1)


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        left = 0
        right = n - 1

        while left <= right:
            mid = left + (right - left) // 2
            if citations[mid] >= n - mid:
                if mid == 0 or citations[mid-1] < n - mid + 1:
                    return n - mid
                else:
                    right = mid - 1
            else:
                left = mid + 1

        return 0
