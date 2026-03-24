# Time Complexity : O(m log m + n log m) where n = forward.length and m = backward.length
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We sort the backward flights first so we can look them up fast.
# For each forward flight, we binary-search the biggest backward leg that still keeps us under the target.
# We track the best total distance so far and store every pair that matches that best.

class Solution:
    def optimalAirRoute(self, forward, backward, target):
        backward.sort(key=lambda a: a[1])
        result = []
        max_val = 0
        for f in forward:
            index = self.binarySearch(backward, target - f[1])
            if index != -1:
                sum_val = f[1] + backward[index][1]
                if sum_val >= max_val:
                    if sum_val > max_val:
                        result = []
                    max_val = sum_val
                    result.append([f[0], backward[index][0]])
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
        return high  # largest ≤ target or -1

# quick test
if __name__ == "__main__":
    s = Solution()
    forward = [[1, 2000], [2, 4000], [3, 6000]]
    backward = [[1, 2000]]
    target = 7000
    print(s.optimalAirRoute(forward, backward, target))
