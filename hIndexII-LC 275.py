# Time Complexity = O(log n)
# Space Complexity = O(1)

class Solution:
    def hIndex(self, citations: list[int]) -> int:
        if len(citations) == 0:
            return 0
        
        n = len(citations)
        low = 0
        high = n - 1
        
        while(low <= high):
            mid = low + (high - low) // 2
            if citations[mid] >= n - mid:
                high = mid - 1          # Move left to find if there is a higher h index
            else:
                low = mid + 1           # Move right
                
        return n - low




# Time Complexity = O(n)
# Space Complexity = O(1)

class Solution:
    def hIndex(self, citations: list[int]) -> int:
        if len(citations) == 0:
            return 0
        
        n = len(citations)
        for i in range(n):
            if citations[i] >= n - i:
                return n - i
            
        
        return 0
