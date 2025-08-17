class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # Time Complexity: O(n)
        # Space Complexity: O(1)
        counter = len(citations)
        for i in range(len(citations)):
            if citations[i] >= counter:
                return counter
            counter -= 1
        return 0