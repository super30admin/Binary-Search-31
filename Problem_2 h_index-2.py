#Linear Search Approach
# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        for i in range(n):
            diff = n-i
            if citations[i]>=diff:
                return diff
        return 0

#Binary Search Approach
# // Time Complexity : O(logn)
# // Space Complexity : O(logn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low = 0
        high = n - 1
        while low <= high:
            mid = low + high - low // 2
            if citations[mid] == n - mid:
                return n - mid
            elif citations[mid] < n - mid:
                low = mid + 1
            else:
                high = mid - 1
        return n - low
