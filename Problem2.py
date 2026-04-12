#275. H-Index II

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        low = 0
        n = len(citations)
        high = n-1

        while low < high:
            mid = low + (high-low)//2
            # print(l,h,mid)
            minCitation = citations[mid]
            papersCount = n - mid
            
            if minCitation < papersCount:
                low = mid+1
            else:
                high = mid
        #verify the final result is valid to avoid edge cases
        if citations[low] < n - low:
            return 0
        return n - low
