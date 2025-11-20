"""
TC: O(logN) {We perform a binary search on the sorted citations array.  
             Each comparison narrows the search space by half.}
SC: O(1) {Only a few pointer variables are used; no extra data structures are required.}

Approach:
We are given a sorted citations array (ascending order) and asked to compute the researcher's h-index.  
The h-index is defined as the maximum h such that the researcher has at least h papers with ≥ h citations.

Key idea:
For each index `mid`, the number of papers on the right side (including mid) is:
        right = n - mid
This `right` value represents a candidate h-index.  
We compare citations[mid] to right to determine whether this candidate is valid or whether we must search left/right.

Steps:
1. Use binary search over the indices of the citations array.
2. Compute `right = n - mid`, the number of papers with citations ≥ citations[mid].
3. If citations[mid] == right → found exact h-index; return it.
4. If citations[mid] < right → citations too small, move right (low = mid + 1).
5. If citations[mid] > right → citations too large, move left (high = mid - 1).
6. If no exact match is found, return n - low, which correctly yields the maximum valid h-index.

This binary-search-based formulation guarantees optimal performance and avoids scanning the array linearly.

This solution ran successfully on Leetcode.
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low, high = 0, n-1

        while low <= high:
            mid = low + (high - low)//2

            right = n - mid

            if citations[mid] == right:
                return right
            elif citations[mid] < right:
                low = mid + 1
            else:
                high = mid - 1
        
        return n - low