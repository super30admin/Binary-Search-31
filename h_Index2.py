'''
Time Complexity: 0(nlogn)
Space Complexity: None
Solution:
1. Binary Search to get the mid and find the intersections
2. To find intersection, calculate "n-mid"
3. If "n-mid" == citation[mid]: This is the exact intersection pt
4. If "n-mid" < citation[mid]: chk for the intersection pt on the lhs as "n-mid" value is decreasing
5. Incase of breech of low and high ptr's; return "n-low" as the intersecting pt 
'''

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        # cal total citations
        n = len(citations)
        
        # binary search to get the intersecting pt
        low = 0
        high = n-1
        
        while low <= high:
            
            # cal mid
            mid = (high-low)//2 + low
            
            # chk the conditions
            if citations[mid] == (n-mid):
                # we have the intersecting pt "Equal"
                low = mid
                break
            
            elif (n-mid) < citations[mid]:
                # either this is our intersecting pt or its on the lhs; we need to chk
                high = mid -1
            
            else:
                # we haven't got the intersection 
                low = mid + 1
            
            continue
        
        # print the intersecting pt
        # print("Intersection pt is:\t",n-low)
        
        return n-low
                