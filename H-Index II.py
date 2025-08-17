# time complexity is o(log(n)), where n is the size of the input
# space complexity is o(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        low = 0
        high = len(citations) - 1
        n = len(citations)
        while(low <= high):
            mid = low + (high - low)//2
            if(n - mid == citations[mid]):
                return n - mid
            elif(n - mid < citations[mid]):
                high = mid - 1
            else:
                low = mid + 1
        return n-low   # finding the low, where n-low papers have citations atleast citations[low]
        
        
#         time complexity is o(n)
#         space complexity is o(1)
        # n = len(citations)
        # for i in range(len(citations)):
        #     if(n - i <= citations[i]):
        #         return n-i
        # return 0
        