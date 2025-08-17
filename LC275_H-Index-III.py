"""
citations = [0,1,3,5,6]

n-h = [5,4,3,2,1]

there are 5 papers with 0 or 0+ citations
there are 4 papers with 1 or more citations
there are 3 papers with 3 or more citations --> ans
there are 2 papers with 5 or more citations
there is 1 paper with 6 or more citations


there are(n-h) papers with h citations

TC = nlog(n)


"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations)== 0 : 
            return 0
        
        n = len(citations)
        for i in range(len(citations)):
            diff = n-i
            
            if diff<=citations[i]:
                return diff
            
        return 0

"""
M2 - Binary Search

"""
# TC O(log n)
# SC O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # diff = n - mid == citations[mid] : return n - mid
        # if n - mid > citations[mid] low = mid + 1
        # else high = mid - 1
        n = len(citations)

        low, high = 0, n - 1
        while low <= high:
            mid = low + (high-low) // 2
            diff = n - mid
            if diff == citations[mid]:
                return diff
            elif diff > citations[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return n - low 

        