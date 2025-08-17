# Time Complexity : log(n) - n is the len(citations)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""

Use binary search to find a first element that meets this condition : citations[i] >= n - i

"""

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """

        n = len(citations)
        l = 0
        r = n-1

        while l <= r:
            mid = l + (r-l)//2

            if citations[mid] == n - mid:
                return n - mid
            elif citations[mid] < n - mid:
                l = mid + 1
            else:
                r = mid - 1
        return n - l



