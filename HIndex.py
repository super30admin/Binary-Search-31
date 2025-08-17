from typing import List
# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         for i in range(len(citations)):
#             diff = len(citations) -i
#             if diff <= citations[i]:
#                 return diff
#         return 0

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        l,h,n=0,len(citations)-1, len(citations)
        while l<=h:
            mid = l+(h-l)//2
            diff = n-mid
            if citations[mid]<diff:
                l=mid+1
            elif citations[mid] > diff :
                h=mid-1
            else:
                return diff
        return n-l
        