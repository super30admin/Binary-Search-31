class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """Binary search
        Time complexity-O(log(n))
        Space complexity-O(1)"""
        start=0
        high=len(citations)-1
        while start<=high:
            mid=start+(high-start)//2
            if citations[mid]==len(citations)-mid:
                return citations[mid]
            elif len(citations)-mid<citations[mid]:
                high=mid-1
            else:
                start=mid+1
        return len(citations)-start
                
                
        """BruteForce approach
        Time complexity-O(n)
        Space complexity-O(1)"""
        # for i in range(len(citations)):
        #     if len(citations)-i<=citations[i]:
        #         return len(citations)-i
        # return 0
        