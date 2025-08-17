def optimalUtilizationBinarySearch(mamaxTravelDist, forwardRouteList, returnRouteList):
    forwardRouteList.sort(key=lambda x: x[1])
    returnRouteList.sort(key=lambda x: x[1])

    result = []
    max_distance = 0

    return_distances = [route[1] for route in returnRouteList]

    for forwardRoute in forwardRouteList:
        forward_id, forward_distance = forwardRoute

        remaining_distance = mamaxTravelDist - forward_distance

        idx = bisect_right(return_distances, remaining_distance) - 1

        if idx >= 0:
            return_id, return_distance = returnRouteList[idx]
            total_distance = forward_distance + return_distance
            if total_distance > max_distance:
                max_distance = total_distance
                result = [[forward_id, return_id]]
            elif total_distance == max_distance:
                result.append([forward_id, return_id])
    return result


# time complexity is O(nlogn)
# space complexity is O(n)
def bisect_right(arr, target):

    lo, hi = 0, len(arr)
    while lo < hi:
        mid = (lo + hi) // 2
        if arr[mid] <= target:
            lo = mid + 1
        else:
            hi = mid
    return lo


maxTravelDist = 7000
forwardRouteList = [[1, 2000], [2, 4000], [3, 6000]]
returnRouteList = [[1, 2000]]

# Output
print(optimalUtilizationBinarySearch(maxTravelDist, forwardRouteList, returnRouteList))
