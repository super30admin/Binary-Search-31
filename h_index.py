# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
#

# binary search
# TC: O(log(n))
class Solution:
    def hIndex(self, citations: list[int]) -> int:
        start = 0
        end = len(citations)-1
        while start <= end:
            mid = start + (end-start)//2
            if citations[mid] == len(citations) - mid:
                return len(citations) - mid
            elif citations[mid] < len(citations)-mid:
                start = mid + 1
            else:
                end = mid - 1
        return len(citations)-start


print(Solution().hIndex([0, 1, 2, 2, 3, 3, 5, 7, 8]))


# TC: O(n)
# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         n = len(citations)
#         for i in range(n):
#             diff = n - i
#             if diff <= citations[i]:
#                 return diff
#         return 0
#
#
# print(Solution().hIndex([0, 1, 2, 2, 3, 3, 5, 7, 8]))
