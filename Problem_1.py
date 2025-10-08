'''
Optimize Air Routes
https://leetcode.com/discuss/post/1025705/amazon-oa-prime-air-time-by-anonymous_us-y1gu/

There are 3 things to be known before attempting this problem: maxTravelDist, it is an integer which represents the maximum operating travel distance of the given aircraft; forwardRouteList, it is a list of pairs of integers where the first integer represents the unique identifier of a forward shipping route and the second integer represents the amount of travel distance required by this shipping route; returnRouteList, a list of pairs of integers where the first integer represents the unique identifer of a return shipping route and the second integer represents the amount of travel distance required by this shipping route.

These three things will be given as an input to you. you need to return a list of pairs of integers representing the pairs of IDs of forward and also return the shipping routes that optimally utilize the given aircraft. If no route is possible, return a list with empty pair.

Example 1: Input: maxTravelDist = 7000 forwardRouteList = [[1,2000],[2,4000],[3,6000]] returnRouteList = [[1,2000]]
Output: [[2,1]]
Explanation: There are only three combinations [1,1],[2,1],and [3,1], which have a total of 4000, 6000, and 8000 miles, respectively. Since 6000 is the largest use that does not exceed 7000, [2,1] is the optimal pair.

Solution:
1. Assume  arr1 = forwardRouteList (len M), arr2 = returnRouteList  (len N).
Assume WLOG that M > N. For every route in forwardRouteList, search for the route in returnRouteList that yields the minimal +ve difference in distance, where difference in distance = target distance - forward dist - return distance. For the search involving the optimal route in returnRouteList, we use binary search to find the infimum of the target in the search array.

Time: O(M log M + N log N + M log N), Space: O(1)
'''

def binary_search_infimum(arr, target):
    ''' Given an array where elements are arranged in sorted increasing order
        and target value not present in the array, find the greatest lower bound (GLB or infimum) in the array using binary search.
        Time: O(log N), Space: O(1)
    '''
    N = len(arr)
    low = 0
    high = N-1
    glb_index = 0
    while low <= high:
        mid = low + (high - low) // 2
        if arr[mid][1] <= target:
            glb_index = mid  # Candidate for GLB
            low = mid + 1    # Search right half
        else:
            high = mid - 1   # Search left half
    return glb_index

def optimize_air_routes(arr1, arr2, target):
    if not arr1 or not arr2 or not target:
        return []

    arr1.sort(key=lambda x: x[1])
    arr2.sort(key=lambda x: x[1])
    M = len(arr1)
    N = len(arr2)

    # WLOG, assume M > N

    # least residual positive dist = dmin = target - forward - return
    dmin = float('inf')
    pair = []
    for i in range(N): # O(N)
        ret_id, ret_dist = arr2[i]
        index = binary_search_infimum(arr1, target - ret_dist) # O(log M)
        src_id, fwd_dist = arr1[index]
        if target >= fwd_dist + ret_dist:
            if fwd_dist + ret_dist < dmin:
                pair = [src_id, ret_id]
                dmin = fwd_dist + ret_dist

    return pair



def run_optimize_air_routes():
    tests = [([[1,2000], [2,3000], [3,4000]], [[1,5000], [2,3000]], 5000,
              [1,2]),
             ([[1,2000],[2,4000],[3,6000]], [[1,2000]], 7000, [2,1]),
    ]
    for test in tests:
        arr1, arr2, target, ans = test[0], test[1], test[2], test[3]
        print(f"\nforwardRouteList = {arr1}")
        print(f"returnRouteList = {arr2}")
        print(f"maxTravelDist = {target}")
        result = optimize_air_routes(arr1, arr2, target)
        print(f"Optimal forward and return Route IDs = {result}")
        success = (ans == result)
        print(f"Pass: {success}")
        if not success:
            print(f"Failed")
            return


run_optimize_air_routes()