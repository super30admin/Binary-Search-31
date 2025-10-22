# Time Complexity: O(nlogn)
# Space Complexity: O(1)
def optimal_route_pairs(maxTravelDist, forwardRouteList, returnRouteList):
    sortedForward = sorted(forwardRouteList, key=lambda x: x[1])
    sortedReturn = sorted(returnRouteList, key=lambda x: x[1])

    p1 = 0
    p2 = len(sortedReturn) - 1
    currMax = 0
    result = []

    while p1 < len(sortedForward) and p2 >= 0:
        currTotal = sortedForward[p1][1] + sortedReturn[p2][1]
        if currTotal <= maxTravelDist:
            if currTotal > currMax:
                currMax = currTotal
                result.clear()
                result.append([sortedForward[p1][0], sortedReturn[p2][0]])
            elif currTotal == currMax:
                result.append([sortedForward[p1][0], sortedReturn[p2][0]])
            p1 += 1
        else:
            p2 -= 1
    return result
