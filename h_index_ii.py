# O(LOG(N)) TIME AND O(1) SPACE WHERE N IS LEN(CITATIONS)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        low = 0
        high = len(citations) - 1
        while low <= high:
            mid = (low + high) // 2
            
            trailHIndex = len(citations) - mid
            
            if(citations[mid] == trailHIndex):
                return trailHIndex
            elif citations[mid] < trailHIndex:
                low = mid + 1
            else:
                high = mid - 1
        
        return len(citations) - low