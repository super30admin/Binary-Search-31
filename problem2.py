class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        low=0
        high=len(citations)-1
        while(low<=high):
            mid=low+(high-low)//2
            print(mid,low,high)
            #we have found optimum point
            if citations[mid]==(n-mid):
                print("here")
                return n-mid
            elif citations[mid]<(n-mid):
                low=mid+1
            else:
                #here is a potential h-index, but keep moving left untill you find optimum
                high=mid-1
        
        return n-low
        #Time O(logn)
        #space O(1)
