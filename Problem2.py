## Problem2
# H-Index II (https://leetcode.com/problems/h-index-ii)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        Time Complexity: O(log n)
        - We use binary search to find the h-index. In each step of the while loop, 
          we cut our search space in half. For an array of size n, this takes at 
          most log(n) operations.

        Space Complexity: O(1)
        - We only allocate a few integer variables (n, l, r, h, mid, papers, cites) 
          to keep track of pointers and counts. This requires constant extra space 
          regardless of the input size.
        """
        n = len(citations)
        
        # Initialize left and right pointers for binary search
        l, r = 0, n - 1
        h = 0
        
        # Edge case: If there is only one paper, the h-index is 1 if it has 
        # at least 1 citation, otherwise it is 0.
        if n == 1:
            return 1 if citations[0] > 0 else 0
            
        # Standard binary search loop
        while l <= r:
            # Safely calculate the middle index to prevent potential integer overflow
            mid = l + (r - l) // 2
            
            # `papers` represents the total number of papers that have at least
            # `citations[mid]` citations. (Since the array is sorted ascendingly, 
            # everything from `mid` to the end is >= citations[mid])
            papers = n - mid
            cites = citations[mid]
            
            # If the count of papers is less than or equal to the citation count at `mid`,
            # this is a valid h-index candidate. 
            if papers <= cites:
                # Update our max h-index found so far
                h = max(h, papers)
                # To find a potentially larger h-index (which requires MORE papers),
                # we must search the left half of the array.
                r = mid - 1
            else:
                # If the count of papers is greater than the citations at `mid`,
                # this is not a valid h-index. We need to look for a position with 
                # FEWER papers but HIGHER citations, so we search the right half.
                l = mid + 1
                
        return h