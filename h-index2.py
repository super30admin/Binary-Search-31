# TC: O(log(N)) :  
# SC: O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


'''
Find the index where citations[i] crosses the n-i value.
We perform a binary search and return the i
     
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        l = 0
        h = n-1
        
        while(l<=h):
            m = l+(h-l)//2
            
            if n-m==citations[m]:
                return n-m
            elif n-m>citations[m]:
                l = m+1
            else:
                h = m-1
        return n-l
    