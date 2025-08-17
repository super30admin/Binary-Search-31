class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        n = len(citations)
        lo, hi = 0, n+1
        while lo < hi:
            mid = (lo + hi)//2
            if citations[-mid] < mid:
                hi = mid
            else:
                lo = mid + 1
        return max(lo-1, 0)