# Time Complexity : O(M+N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using two pointers left and right. Iterate left pointer on forwardRouteList and right pointer in reverse order on returnRouteList
# If the arrays are not sorted we need to sort the arrays first
# Then check if distance at index left and distance at index right > maxtraveldist
# If it is then decrement the right pointer by 1
# Else we need to update the maxdist if less than current distance and append the routes to res and increment left pointer by 1
# Return res


class Solution:
    def optimizeRoutes(self, maxTravelDist, forwardRouteList, returnRouteList):
        if not maxTravelDist:
            return 0
        left = 0
        right = len(returnRouteList) - 1
        res = []
        maxdist = 0
        while left < len(forwardRouteList) and right >= 0:
            if (forwardRouteList[left][1] +
                    returnRouteList[right][1]) > maxTravelDist:
                right -= 1
            else:
                if maxdist <= forwardRouteList[left][1] + returnRouteList[
                        right][1]:
                    maxdist = forwardRouteList[left][1] + returnRouteList[
                        right][1]
                    res.append(
                        (forwardRouteList[left][0], returnRouteList[right][0]))
                left += 1
        return res


sol = Solution()
print(
    sol.optimizeRoutes(8500, [[1, 2000], [2, 4000], [3, 6500], [4, 8000]],
                       [[1, 3000], [2, 4000], [3, 6000], [4, 7000]]))
