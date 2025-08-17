class Solution:
    # Binary Search solution
    # TC : O(log n)
    # SC : O(1)
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        maxval = 0
        n=len(citations)
        low,high = 0,n-1
        while low <=high:
            mid = low + (high-low)//2
            if citations[mid] >= n-mid:
                high = mid -1
            else:
                low = mid + 1
        return n-low
        