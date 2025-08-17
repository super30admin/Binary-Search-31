# TC : O(n)
# SC : O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        '''
        n = len(citations)
        for i in range(n):
            if citations[i]>=(n-i):
                return n-i
        return 0
        '''
        start = 0
        end = len(citations)-1
        n = len(citations)
        while(start<=end):
            mid= start + (end-start)//2
            if (citations[mid]==(n-mid)):
                return n- mid
            elif(citations[mid]<(n-mid)):
                start = mid+1
            else:
                end = mid-1
        return n - start
                
            