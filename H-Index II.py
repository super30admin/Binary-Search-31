class Solution:
    def hIndex(self, citations: List[int]) -> int:
        #Approach: Linear Search
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        
        n = len(citations)
        
        for i in range(n):
            if citations[i] >= n - i:
                return n - i
            
        return 0