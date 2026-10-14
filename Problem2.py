# Problem2: H-Index II (https://leetcode.com/problems/h-index-ii)
# TC: O(log n), the search range halves every step
# SC: O(1), only a few variables
# Approach:
# citations is sorted, so for index i, there are (n - i) papers with >= citations[i] citations.
# We need the first index i where citations[i] >= n - i. Then h = n - i.
# The condition goes from false to true once, so we can use binary search.
# Exact match (citations[mid] == n - mid) is the best answer, return it.
# Otherwise, low ends at the first index where the condition is true.

class Solution:
    def hIndex(self, citations: list[int]) -> int:
        n = len(citations)                  # total number of papers
        low, high = 0, n-1                  # search range over all indexes

        while low <= high:                  # run until the range is empty
            mid = low + (high-low)//2       # middle index
            diff = n - mid                  # papers from mid to end = h we are testing

            if diff ==citations[mid]:       # exact match, h = diff is valid and the best
                return diff
            
            elif diff > citations[mid]:     # too few citations for diff papers, condition fails
                low = mid +1                # go right to get a bigger citation value
            else:                           # citations[mid] > diff, condition is true
                high = mid -1               # go left to look for an earlier valid index
        return n-low                        # low = first valid index, so h = n - low (0 if none)
        