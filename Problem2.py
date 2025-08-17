"""
275. H-Index II
Time Complexity - O(log n)
Space Complexity - O(1)
Calculate mid of list and verify if mid vlue == trialHIndex , then return trialHindex 
if mid value less than trialindex increment low to mid+1 else change high to mid-1"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        size = len(citations)
        low = 0
        high = size - 1
        while(low <= high):
            mid = low +(low+high)//2
            trialHIndex = size- mid
            
            if (citations[mid] == trialHIndex):
                return trialHIndex
            elif (citations[mid] < trialHIndex):
                low = mid + 1
            else:
                high = mid - 1
        return size - low