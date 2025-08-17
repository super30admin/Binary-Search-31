# Time Complexity : O(log n) because we are dividing by 2
# Space Complexity : O(l1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# cit[i] are the citations for paper number i
# h - if we have h no of papers, cited atleast h times
# sorted in ascending order
# so we have cit[0] - there are n - i papers that are cited atleast c[0] times, because all members after cit[0] are greater than cir[0]
# it means that all the papers are cited atleast cit[0] no of times
# similarly, all papers, will be cited atleast n - i times (from cit[i] to cit[n-1])
# so we have to find max n - i
# and we do binary search, such that we can maximize n - i
# and we are looking for n - i, so if i is small, overall n - i wil be greater
# thus we move towards smaller i => towards left, so that n - i can be bigger
# else we move right

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if citations is None:
            return 0
        
        n = len(citations)
        low = 0
        high = n - 1
        while (low <= high):
            mid = (low + high) // 2
            if citations[mid] >= n - mid:
                # go left, because on left mid will decrease
                # so n - mid (potential h) will increase
                high = mid - 1
            else:
                # move right
                # should look for higher citations
                low = mid + 1
        
        return n - low

        # o(n) solution:
        
        # for i in range(n):
        #     if citations[i] >= n - i:
        #         return n - i
        
        # return 0
