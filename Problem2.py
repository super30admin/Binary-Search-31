"""
I used binary search on the sorted citations list to find the H-Index. At each step, I compare the citation at the middle index with the number of papers that have at least that many citations. Based on the comparison, I adjust the search range. If there's no exact match, the H-Index is calculated as n - left.
Time Complexity: O(log n)
Space Complexity: O(1)
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:

        left, right = 0, len(citations) - 1
        n = len(citations)
        while left <= right:
            mid = left + (right - left) // 2
            if citations[mid] == n - mid:
                return n - mid
            elif citations[mid] < n - mid:
                left = mid + 1
            else:
                right = mid - 1
        return n - left