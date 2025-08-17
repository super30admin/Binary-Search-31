"""
The problem is same as the 2 sum problem, the only difference being the numbers are divided into two array so we cannot
use the hash map solution.
https://leetcode.com/discuss/interview-question/1213316/amazon-oa-sde-i-2-coding-questions
https://www.careercup.com/question?id=5750442676453376
"""
# Approach 1: two pointer
#TC: O(n + m) | n = len(forward_r) and m = len(return_r)
#SC: O(1)
def optimal_routes( max_dist, forward_r, return_r ):
    low = 0
    high = len(return_r) - 1
    result = [0, 0, float('-inf')]
    while low < len(forward_r) and high> -1:
        total = forward_r[low][1] + return_r[high][1]
        if total > max_dist:
            high -= 1

        else:
            if total > result[2]:
                result = [forward_r[low][0] , return_r[high][0], total]
            low += 1
    result.pop()
    return result

# approach 2: Nearest Binary Search
"""
TC: O( m log n ) | n = len(forward_r) and m = len(return_r)
SC: O(1)
"""
def optimal_routes( max_dist, forward_r, return_r ):
    n = len(forward_r)
    m = len(return_r)
    result = [0, 0, float('-inf')]
    for i in range(m, ): # iterate through return_r i.e the smaller list
        compliment = max_dist - return_r[i][1]
        low = 0
        high = n - 1

        while low <= high: # nearest Binary search on the larger list
            mid = low + (high - low)//2
            if forward_r[mid][1] == compliment:
                if forward_r[mid][1] > result[2]:
                    result = [forward_r[mid][0], return_r[i][0], forward_r[mid][1] +  return_r[i][1]]
                break
            elif forward_r[mid][1] < compliment:
                low = mid + 1
            else:
                high = mid - 1
        result = [forward_r[high][0], return_r[i][0], forward_r[high][1] +  return_r[i][1]] # high will end up at the\
        # optimal candidate for each compliment

    result.pop()
    return result

#test cases
maxTravelDist = 7000
forwardRouteList = [[1, 2000], [2, 4000], [3, 6000]]
returnRouteList = [[1, 2000]]
print(optimal_routes( maxTravelDist, forwardRouteList, returnRouteList))

maxTravelDist  = 11000
forwardRouteList  = [[1,3000],[2,5000]]
returnRouteList  = [[1,2000],[2,3000],[3,4000]]
print(optimal_routes( maxTravelDist, forwardRouteList, returnRouteList))
