'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations: return 0

        for i in range(len(citations)):
            diff = len(citations) - i
            if diff <= citations[i]:
                return diff
        return 0    