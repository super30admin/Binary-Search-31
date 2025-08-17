"""
*** EASY TO FORGET, TRICKY TO UNDERSTAND ***
Approach 1 : Linear search
to easily understand, just mathematically represent the given text:
For a number to be h index,
condition 1: h out of n papers have h or more citations
    a) note h index can only be between 0 to n , n -> number of papers written by the researcher
    b) mathematically you can say h papers >= h citations

condition 2: n-h papers have no more than h citations
    a) mathematically, n - h papers <= h citations

condition 3: if multiple candidates satisfy condition 1 and 2, then the max candidate is h-index
    a) mathematically h = max(all possible h's)
    so lets start with the highest possible value for h in the linear search i.e. n

steps:
1) starting from the higest value, generate all possible h values
2) check if condition 2 satifies. if it does, condition 1 will automatically be satisfied
    a) if the current candidate is h, then n-h papers each should have h or less citations
    b) in order to check this condition, go to (n-h+1)th paper. Example, if n-h = 2, go to the 3rd paper the author has written and check the number of citations if that is h or greater than h
    you know that the papers before this one have h or less citations since the given array is       sorted
    c) luckyly, (n-h)th index goes to (n-h+1)th paper since indicies start from 0
3) simply return the candidate if the condition satisfies.

TC: O(n)
SC: O(1)
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        for h_index in range(n, 0, -1):  # note we cannot go all the way to zero because N-0 would go out of bound
            if citations[n - h_index] >= h_index:
                return h_index
        return 0
        """
        n = len(citations)
        for h_index in range(n, 0, -1):
            h_index = n - i # generate candidate
            if citations[n - h_index] >= h_index: # n - h is nothing but i
                return h_index
        return 0
        """

    # Approach 2: Binary search
    """
    1) use the same concept as above and implement binary search
    2) note that you cannot use n - h >= h_index since there might be an even higher value that can be h_index
    3) also the low pointer ends up at the correct position when you exit out of the loop

    TC: O(log n)
    SC: O(1)
    """

    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low = 0
        high = n - 1

        while low <= high:  # < and = is necessary becasue your low and high can end up at a lower candidate
            mid = low + (high - low) // 2
            h_index = n - mid
            if h_index == citations[mid]:
                return h_index

            elif h_index > citations[mid]:
                low = mid + 1

            else:
                high = mid - 1

        return n - low  # when low crosses high, low would be at the h_index
