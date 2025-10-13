'''
Solution 1: Brute force
    - Iterate over the citations list
    - difference = total papers - i, which is these many papers got >=citations[i]
    - if difference<=citations[i] for the first time, then this is the h-index
Time complexity: O(N)
Space Complexity: O(1)
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        for i in range(len(citations)):
            diff = n-i # these many papers got citations>=citations[i]
            if diff<=citations[i]:
                return diff
        
        return 0 

'''
Solution 2: Binary search
    - h_index range :  (0 to total papers)
    - Binary search on h_index range
Time complexity: O(logN)
Space Complexity: O(1)
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        left = 0
        right = n-1

        while left<=right:
            mid = left + (right-left)//2

            difference  = n-mid # total papers on right of mid
            if difference==citations[mid]:
                return difference
            elif difference<citations[mid]:
                # go to left-half
                right = mid-1
            else:
                left = mid+1
        
        return n-left
        

