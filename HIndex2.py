# Time is O(n) and space is O(1)

# The intuition is to first calculate the h index for each citation and at any given point where the h index < citation the flip that happens we can return the max index.

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        for i in range(n):
            h = n - i
            if h <= citations[i]:
                return h
        return 0

    #Time is O(logn). Here we are using binary search to determine the h index where the flip happens and then return length of citations subtracted by where we found the flip
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low = 0
        high = n - 1

        while (low <= high):
            mid = low + (high - low) // 2

            h = n - mid

            if h == citations[mid]:
                return h
            elif h > citations[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return n - low