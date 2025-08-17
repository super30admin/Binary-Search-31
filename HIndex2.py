
class Solution:
    '''
    Complexity:
    TIme: O(logn)
    Space: O(1)
    '''
    def hIndex(self, citations: List[int]) -> int:
        low = 0
        high = len(citations)-1
        N = len(citations)
        k = 0
        while(high>=0 and low<len(citations) and low<=high):
            mid = (low+high)//2
            if(citations[mid]>=N-mid):
                k = N-mid
                high = mid - 1
            else:
                low = mid+1  
        return k
