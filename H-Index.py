'''
Solution:
1.  As the array is sorted, the (number of papers) with at least (number of citations) present
    at each index would be (N - index).
2.  There would be a sign flip at a particular index with (number of citations) >= (N - index).
3.  This location of sign flip can be found using either linear traversal or binary search.
Time Complexity:    O(n) - Linear Approach; O(logn) - Binary Search Approach
Space Complexity:   O(1) - both approaches
--- Passed all testcases successfully on Leetcode.
'''


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations) == 0:
            return 0
        n = len(citations)
        
        low = 0 
        high = n-1
        
        while(low <= high):
            mid = low + int((high-low)/2)
            diff = n - mid
            if diff == citations[mid]:
                return diff
            
            elif diff > citations[mid]:
                low = mid+1
            
            else:
                high = mid -1
                
        return n - low
                

'''
Brute force solution Linear Solution
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations) == 0:
            return 0
        n = len(citations)
        for i in range(n):
            diff = n-i
            if citations[i]>= diff:
                return diff
        
        return 0