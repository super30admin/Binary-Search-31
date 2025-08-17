# Time Complexity - O(log n)
# space complexity - O(1)
# runs on leetcode - YES
# Any problems while coding it out  - No
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        lo, hi = 0, n
        while lo < hi:
            mid = (lo + hi)//2
            if citations[mid] < n - mid:
                lo = mid + 1
            else:
                hi = mid
        return n - lo