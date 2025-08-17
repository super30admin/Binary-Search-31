# Time: O(log(n))
# Space: O(1)
# Did it run on Leetcode: Yes
# any issues- no

# we do a binary search on the indeices and see if the mid is equal to the diff of length and index - if yes we return that values.
# else we updatethe boundaries of binary search respectively
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n=len(citations)
        if n==0:
            return -1
        low,high=0,n-1
        while(low<=high):
            mid=(low+high)//2
            diff=n-mid
            if(citations[mid]==diff):
                return citations[mid]
            elif(citations[mid]>diff):
                high=mid-1
            else:
                low=mid+1
        
        return n-low