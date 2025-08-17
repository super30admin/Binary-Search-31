# TC: O(n)
# SC: O(1)
class Solution:
    # def hIndex(self, citations):
    #     n=len(citations)
    #     for i in range(len(citations)):
    #         diff=n-i
    #         if diff<=citations[i]:
    #             return diff
    #     return 0

# TC: O(log(n))
# SC: O(1)
    def hIndex(self, citations):
        n=len(citations)
        l=0
        h=n-1
        while l<=h:
            mid=l+(h-l)//2
            dif=n-mid
            if dif==citations[mid]:
                return n-mid
            elif dif<citations[mid]:
                h=mid-1
            else:
                l=mid+1
        return n-l