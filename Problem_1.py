from typing import List
class Solution:
    def optimizeRoutes(self, maxDist: int, forwardRoute: List[List[int]], returnRoute: List[List[int]]) -> List[List[int]]:
        result = []
        if len(forwardRoute) == 0 or len(returnRoute) == 0:
            return []
        l = 0
        r = len(returnRoute) - 1
        ans = 0
        while l < len(forwardRoute) and r >= 0:
            curr = forwardRoute[l][1] + returnRoute[r][1]
            if curr > maxDist:
                r -= 1
            else:
                if ans <= curr:
                    if ans < curr:
                        result = []
                        ans = curr
                    result.append([forwardRoute[l][0], returnRoute[r][0]])
                    count = r
                
                    while count > 0 and returnRoute[count][1] == returnRoute[count - 1][1]:
                        result.append([forwardRoute[l][0], returnRoute[count - 1][0]])
                        count -= 1
                l += 1    
        return result

# Time Complexity: O(llen(forwardRoute) + len(returnRoute))
# Space Complexity : O(1)

obj = Solution()
print(obj.optimizeRoutes(7000, [[1,2000],[2,4000],[3,6000]], [[1,2000]]))
print(obj.optimizeRoutes(7000, [[1, 1000], [2,3000],[3,4500], [4, 6000]], [[1, 2000], [2, 2500], [3, 3500], [4, 6500]]))
print(obj.optimizeRoutes(10, [[1, 3], [2, 5], [3, 7], [4, 10]], [[1, 2], [2, 3], [3, 4], [4, 5]]))