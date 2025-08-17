#Time complexity is O(logm) where m is the length of the citations array
#Space complexity is O(1)
#No issues faced while coding
#COde ran successfully on leetcode
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        #Initializing the required variables with their required values
        low=0
        n=len(citations)
        high=len(citations)-1
        while(low<=high):
            #We will find the mid and difference
            mid=low+(high-low)/2
            diff=n-mid
            #Based on difference, it will go into following conditional statement
            if(diff==citations[mid]):
                return diff
            elif(diff<citations[mid]):
                high=mid-1
            else:
                low=mid+1
        #Finally we will return the value
        return n-low
        