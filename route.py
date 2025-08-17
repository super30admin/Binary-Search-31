# Time complexity: O(n log n + m log m)
# Space complexity: O(1)

def optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList):
    forwardRouteList.sort(key=lambda x: x[1])
    returnRouteList.sort(key=lambda x: x[1])
    
    result = []
    max_sum = float('-inf')
    
    i, j = 0, len(returnRouteList) - 1
    
    while i < len(forwardRouteList) and j >= 0:
        total = forwardRouteList[i][1] + returnRouteList[j][1]
        
        if total <= maxTravelDist:
            if total > max_sum:
                max_sum = total
                result = [[forwardRouteList[i][0], returnRouteList[j][0]]]
            elif total == max_sum:
                result.append([forwardRouteList[i][0], returnRouteList[j][0]])
            i += 1
        else:
            j -= 1
    
    return result
