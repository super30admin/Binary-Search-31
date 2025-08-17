"""
Sort the returnRouteList by distance and For each forwardRoute, find remaining distance
Binary search in returnRouteList for the largest return distance ≤ remaining
Track all pairs with max valid sum ≤ maxTravelDist
"""
"""
Time Complexity: Sort: O(m log m) For each forward route (n), binary search in return list: O(n log m) ; Total: O(n log m)
Space Complexity: O(1) extra
"""

from typing import List
import bisect

class closestPairs:
    def optimalUtilization(self, maxTravelDist: int, 
                           forwardRouteList: List[List[int]], 
                           returnRouteList: List[List[int]]) -> List[List[int]]:
        
        
        returnRouteList.sort(key=lambda x: x[1])
        returnDists = [x[1] for x in returnRouteList]
        
        maxSum = float('-inf')
        result = []

        for fid, fdist in forwardRouteList:
            remaining = maxTravelDist - fdist
            idx = bisect.bisect_right(returnDists, remaining) - 1
            
            if idx >= 0:
                rdist = returnDists[idx]
                total = fdist + rdist

                if total > maxSum:
                    maxSum = total
                    result = [[fid, returnRouteList[idx][0]]]
                elif total == maxSum:
                    result.append([fid, returnRouteList[idx][0]])

        return result if result else [[]]


if __name__ == "__main__":
    optimizer = closestPairs()

    maxTravelDist = 7000
    forwardRouteList = [[1, 2000], [2, 4000], [3, 6000]]
    returnRouteList = [[1, 5000], [2, 3000]]

    print(optimizer.optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList))
