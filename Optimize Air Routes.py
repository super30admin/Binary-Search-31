# Time Complexity : O(mlogm + nlogm)   m -> Length of backward array   n -> Length of forward array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach: This code finds all pairs of routes (one from forward, one from backward) whose combined distance is as close as possible to target without exceeding it. It sorts the backward array, then for each forward route, uses binary search to find the best possible backward route that keeps the sum ≤ target. The result collects all such optimal pairs that achieve the maximum feasible sum.

class Solution:
    # TC: O(mlogm + nlogm)   m -> Length of backward array   n -> Length of forward array SC: O(1)
    def optimalAirRoute(self, forward, backward, target):
        backward.sort(key = lambda a : a[1])
        maxVal = 0
        result = []
        
        for f in forward:
            idx = self.binarySearch(backward, target - f[1])
            if idx != -1:
                sumVal = f[1] + backward[idx][1]
                if sumVal >= maxVal:
                    if sumVal > maxVal:
                        result = []
                    maxVal = sumVal
                    result.append([f[0], backward[idx][0]])
        
        return result
        
    def binarySearch(self, backward, target):
        low, high = 0, len(backward) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if backward[mid][1] == target:
                return mid
            elif backward[mid][1] < target:
                low = mid + 1
            else:
                high = mid - 1
            
        return high
        
if __name__ == "__main__":
    s = Solution()
    forward = [[1, 2000], [2, 4000], [3, 6000]]
    backward = [[1, 2000]]
    target = 7000
    res = s.optimalAirRoute(forward, backward, target)
    for pair in res:
        print(f"{pair[0]},{pair[1]}")