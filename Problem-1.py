# Time Complexity : O(M log M + N log M), M = len(returnRouteList), N = len(forwardRouteList)
# Space Complexity : O(M + R), R = number of optimal pairs returned
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Sort the return routes by distance to allow binary search.
# 2. For each forward route, use binary search to find the best return route 
#    that maximizes the total distance without exceeding maxTravelDist.
# 3. Collect all pairs achieving the optimal total distance.

from typing import List
import bisect

class Solution:
    def optimizeAirRoutes(self, maxTravelDist: int, 
                          forwardRouteList: List[List[int]], 
                          returnRouteList: List[List[int]]) -> List[List[int]]:

        # Sort return routes by distance
        returnRouteList.sort(key=lambda x: x[1])
        distances = [r[1] for r in returnRouteList]  # distances only
        optimal = []
        max_sum = -1
        
        # For each forward route, find the best compatible return route
        for f_id, f_dist in forwardRouteList:
            remaining = maxTravelDist - f_dist
            # Binary search: largest return distance <= remaining
            idx = bisect.bisect_right(distances, remaining) - 1
            if idx >= 0:
                total = f_dist + distances[idx]
                if total > max_sum:
                    max_sum = total
                    optimal = [[f_id, returnRouteList[idx][0]]]
                elif total == max_sum:
                    optimal.append([f_id, returnRouteList[idx][0]])
        
        return optimal if optimal else [[]]
