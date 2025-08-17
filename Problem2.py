#Time Complexity :- O(logn)
#Space Complexity :- O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        low = 0
        high = len(citations)-1
        n = len(citations)


        while low <=high:
            mid = (low+high)//2
            diff = n - mid
            if citations[mid] == diff:
                return n-mid
            if citations[mid] > diff:
                high = mid -1
            else:
                low = mid +1
            
        return n-low


#ANothe Approach :-
#Time Complexity :- O(n)
#Space Complexity:- O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        for i in range(n):
            diff = n-i
            if diff <= citations[i]:
                return diff
        return 0