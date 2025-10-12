class Solution(object):
    # tc : O(logn)
    # sc : O(1) no extra space used
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        # since we know its a sorted array, at a index i we will have papers form this ith index to the end of the list number of papers with citations greater or equal to citation[i]
        # i.,e the number of papers with citations[i] is n-i and our hindex is the index where there are atleast h papers( n-i) that have been cited atleast h times
        # so our h should be equal or less than citations[i], that's when we hit the coniditon and return our h 

       # performing the binary search : since arr is sorted, our n-i difference will also be in a sorted order 
       # if at a point n-mid is > citations[mid] then we have to move right of the arr, as the left part will also be greater and does nto contain the max value of h index
       # if its equal we found the conditon where it has atleast h papers case and we can return the mid,
       # if its < then we move to the left ofthe arr to find the most optimal low point and return n-low  

        n = len(citations)
        low = 0
        high = n-1

        while (low<=high):
            mid = low + (high-low)//2
            diff = n-mid

            if diff == citations[mid]:
                return diff # found the hindex 
            elif diff < citations[mid]: #a valid hindex but we can get even optimal by moving left 
                high = mid -1 
            else : 
                low = mid +1

        return n - low 



