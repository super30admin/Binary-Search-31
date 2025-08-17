# Time Complexity :
# O(log N)

# Space Complexity :
# O(1) 

# Did this code successfully run on Leetcode :
#Yes

#We are trying to do a binary search for the location of the h-index. If the citation value at any location is greater than number of papers to the right, then the h-index lies to the left, right otherwise
#We keep doing this until we have ptr1 and ptr2 cross. It is possible we did not find the h-index at all - in those cases we return 0 or the distance from the ptr1 to the end as that represents the number of papers

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) == 1 :
            if citations[0] != 0 :
                return 1
        ptr1 = 0
        ptr2 = len(citations)-1
        min_h_index = 0

        while ptr1 < ptr2 :
            mid = ptr1 + int((ptr2 - ptr1)/2)
            if citations[mid] >= len(citations)- mid:
                ptr2 = mid
            else :
                ptr1 = mid + 1

        if citations[ptr1] >= len(citations) - ptr1 :
            return len(citations) - ptr1
        return 0
