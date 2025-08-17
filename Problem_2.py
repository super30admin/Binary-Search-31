"""
Problem : 2

Time Complexity : 
Bruteforce - O(n)
Binary Search - O(logn)

Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


initializing a hindex variable to calculate hindex, start iterating over the citations array
if there are the number of papers remaining is greater than or equal to the current citations, that means, they all have at least citation equal to current citations
henc their hindex would be the current citations, but if there are less papers than the number of current citations, then it means those papers have at least citations
equal to the number of papers remaing, and returning the hindex at the end
"""

# H-index II


# Approach - 1
# Bruteforce

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        hindex=0
        n=len(citations)
        for i in range(n):
            papers=n-i
            if papers>=citations[i]:
                hindex=max(citations[i],hindex)
            else:
                hindex=max(papers,hindex)
        return hindex
    
# Approach - 2
# Binary Search

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        l=0
        r=len(citations)-1
        n=len(citations)
        while l<=r:
            mid=l+(r-l)/2
            papers=n-mid
            if papers==citations[mid]:
                return papers
            
            elif papers<citations[mid]:
                r=mid-1
            else:
                l=mid+1

        return n-l