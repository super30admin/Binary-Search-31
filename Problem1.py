## Problem1
# Optimize Air Routes (https://leetcode.com/discuss/post/1459915/amazon-oa-prime-air-time-by-anonymous_us-jgts/) 

# There are 3 things to be known before attempting this problem:
# maxTravelDist, it is an integer which represents the maximum operating travel distance of the given aircraft;
# forwardRouteList, it is a list of pairs of integers where the first integer represents the unique identifier of a forward shipping route and the second integer represents the amount of travel distance required by this shipping route;
# returnRouteList, a list of pairs of integers where the first integer represents the unique identifer of a return shipping route
# and the second integer represents the amount of travel distance required by this shipping route.

# These three things will be given as an input to you. you need to return a list of pairs of integers representing the pairs of IDs of forward and also return the shipping routes that optimally utilize the given aircraft. If no route is possible, return a list with empty pair.

# Example 1:
# Input:
# maxTravelDist = 7000
# forwardRouteList = [[1,2000],[2,4000],[3,6000]]
# returnRouteList = [[1,2000]]

# Output:
# [[2,1]]

# Explanation:
# There are only three combinations [1,1],[2,1],and [3,1], which have a total of 4000, 6000, and 8000 miles, respectively. Since 6000 is the largest use that does not exceed 7000, [2,1] is the optimal pair.


class Solution:
    def mostOptimalPairs(self, maxTravelDist: int, forwardRouteList: list[list[int]], returnRouteList: list[list[int]]) -> list[list[int]]:
        """
        Finds the forward and return route pairs that maximize the travel distance
        without exceeding maxTravelDist.
        
        Complexity Analysis:
        --------------------
        TIME COMPLEXITY: O(N log N + M log M)
          - Sorting forwardRouteList takes O(N log N), where N = len(forwardRouteList).
          - Sorting returnRouteList takes O(M log M), where M = len(returnRouteList).
          - The two-pointer traversal takes O(N + M) on average since 'left' or 'right' 
            moves closer to termination in each main loop iteration.
          - In the absolute worst-case scenario (where all inputs share the exact same 
            distance value), the duplicate loop could degrade traversal to O(N * M), 
            but for typical real-world data, the sorting operations remain the dominant cost.
            
        SPACE COMPLEXITY: O(1) Auxiliary Space
          - Python's .sort() method sorts the input lists in-place, consuming no 
            additional auxiliary memory.
          - Note: Memory used to store and return the 'result' list is O(K), where K 
            is the number of valid optimal pairs. Output space is generally excluded 
            from auxiliary space calculations.
        """
        # Alias inputs for cleaner notation
        F = forwardRouteList
        R = returnRouteList
        
        # Sort both lists by distance (the second element in each pair)
        # Time: O(N log N) for F, O(M log M) for R
        F.sort(key=lambda x: x[1])
        R.sort(key=lambda x: x[1])
        
        maxdist: int = -1
        left: int = 0
        right: int = len(R) - 1
        result = []
        
        # Two-pointer traversal - Avg Time: O(N + M)
        while left < len(F) and right >= 0:
            fid: int
            fd: int
            fid, fd = F[left]
            
            rid: int
            rd: int
            rid, rd = R[right]
            
            currDist = fd + rd
            
            # If the current distance exceeds the maximum allowed budget,
            # we must reduce the distance by moving the right pointer to a smaller return route.
            if currDist > maxTravelDist:
                right -= 1
            else:
                # If we found a combined distance strictly greater than our previous max,
                # discard the old inferior results and update maxdist.
                if maxdist < currDist:
                    maxdist = currDist  # Fixes original tracking bug to ensure true maximum is maintained
                    result = [[fid, rid]]
                # If the current distance matches our best-known maximum, append it to the results.
                elif currDist == maxdist:
                    result.append([fid, rid])
                
                # EDGE CASE HANDLE: Look backward from the 'right' pointer to find any duplicate 
                # return flight distances. We use a temporary pointer because these same duplicate 
                # return routes might also need to be paired with subsequent forward routes.
                tempRight = right - 1
                while tempRight >= 0 and R[tempRight][1] == rd:
                    if currDist == maxdist:
                        result.append([fid, R[tempRight][0]])
                    tempRight -= 1
                
                # Since the current combination is valid, advance the left pointer 
                # to explore larger forward distance options.
                left += 1
                
        return result

# --- Verification & Testing ---
maxDist: int = 7000
forward: List[List[int]] = [[1, 2000], [2, 4000], [3, 6000]]
backward: List[List[int]] = [[1, 2000]]

m = 5000
f = [[1, 2000]]
r = [[10, 3000], [11, 3000]]

obj = Solution()
print(obj.mostOptimalPairs(maxDist, forward, backward))  # Output: [[2, 1]]
print(obj.mostOptimalPairs(m, f, r))                    # Output: [[1, 11], [1, 10]]