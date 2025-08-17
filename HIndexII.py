#Time Complexity: O(log(n))
#Space Complexity: O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low = 0
        high = n-1

        while low<=high:
            mid = (low+high)//2
            diff = n-mid
            if citations[mid]>=diff :
                if mid==0 or citations[mid-1]<diff+1:
                    return n-mid
                high = mid-1
            elif citations[mid]<diff:
                low= mid+1
            else:
                high = mid-1
        return n-low