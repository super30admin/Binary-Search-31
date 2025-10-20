#Amazon online assessment question. Time complexity is O(nlogn) as we have to sorte the forward and return route list
# Space is O(1) auxiliary space.

# The intuition is to calculate the closest value to max travel distance using two pointers. But the brute force would be O(n^2). Hence sorted it and used 2 pointers.

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