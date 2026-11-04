# Time Complexity : O(M+N)
# Space Complexity : O(1)
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
    def optimizeAirRoutes(self, maxTravelDist, forwardRoutesList, returnRoutesList):
        if not forwardRoutesList or not returnRoutesList:
            return [[]]
        result = []
        maxdist = -1
        for forward in forwardRoutesList:
            for backward in returnRoutesList:
                total = forward[1] + backward[1]
                if total <= maxTravelDist:
                    if maxdist < total:
                        maxdist = total
                        result = [[forward[0], backward[0]]]
                    elif total == maxdist:
                        result.append([forward[0], backward[0]])
        return result
#Time - O(mn)
#Space - O(1)

class Solution:
    def optimizeAirRoutes(self, maxTravelDist, forwardRoutesList, returnRoutesList):
        if not maxTravelDist:
            return 0
        left = 0
        right = len(returnRoutesList) - 1
        result = []
        maxdist = 0
        forwardRoutesList.sort(key=lambda x: x[1])
        returnRoutesList.sort(key=lambda x: x[1])
        while left < len(forwardRoutesList) and right >= 0:
            total = forwardRoutesList[left][1] + returnRoutesList[right][1]
            if total > maxTravelDist:
                right -= 1
            else:
                if maxdist < total:
                    maxdist = total
                    result = [(forwardRoutesList[left][0], returnRoutesList[right][0])]
                elif total == maxdist:
                    result.append((forwardRoutesList[left][0], returnRoutesList[right][0]))
                left += 1
        return result

sol = Solution()
print(
    sol.optimizeAirRoutes(8500, [[1, 2000], [2, 4000], [3, 6500], [4, 8000]],
                       [[1, 3000], [2, 4000], [3, 6000], [4, 7000]]))
print(
    sol.optimizeAirRoutes(10, [[1, 2], [2, 5]],
                       [[1, 3]]))


