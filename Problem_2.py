class Solution:
    def hIndex(self, citations):
        n = len(citations)
        low, high = 0, n - 1
        while low <= high:
            mid = low + (high - low) // 2
            curr = citations[mid]
            if curr < n - mid:
                low = mid + 1
            else:
                high = mid - 1
        return n - low
