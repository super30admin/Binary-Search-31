## Problem1:Optimize Air Routes (https://leetcode.com/discuss/interview-question/1025705/Amazon-or-OA-or-Prime-Air-time/824897)
# Time Complexity: O(m log m + n log m),Sort backward: O(m log m),n forward routes, each one binary search: O(log m)
# Space Complexity: O(1) extra (not counting the output list) Python's sort may use up to O(m) internally.
# Goal:
#   Pick one forward and one backward route so that
#   forward + backward <= target, and the total is as big
#   as possible. Return all pairs that tie for the best total.
# Approach:
#  Sort backward by distance so we can binary search it.
#  For each forward route, room left = target - forward distance.
#  Binary search for the biggest backward distance <= room.
#  Track the best total:
#    bigger -> clear old pairs, save this pair
#    equal  -> add this pair
#    smaller -> ignore
#   Return the pairs ([] if none fit).


class Solution:
    def optimalAirRoute(self, forward, backward, target):
        # sort backward by distance (index 1) so binary search works
        backward.sort(key=lambda a: a[1])

        result = []   # stores all best pairs [forward_id, backward_id]
        max_val = 0   # best total distance found so far

        for f in forward:  # f = [id, distance]
            # room left after using this forward route
            # find index of biggest backward distance that fits in it
            index = self.binarySearch(backward, target - f[1])

            if index != -1:  # -1 means no backward route fits
                # total distance of this pair
                sum_val = f[1] + backward[index][1]

                if sum_val >= max_val:  # tie or better than best so far
                    if sum_val > max_val:
                        result = []  # strictly better, old pairs are useless
                    max_val = sum_val  # update best total
                    # save pair: forward id, backward id
                    result.append([f[0], backward[index][0]])

        return result  # all best pairs, or [] if none fit

    def binarySearch(self, backward, target):
        low, high = 0, len(backward) - 1  # search the whole list

        while low <= high:  # while the range is not empty
            mid = low + (high - low) // 2  # middle index

            if backward[mid][1] == target:
                return mid  # exact fit, best possible
            elif backward[mid][1] < target:
                low = mid + 1   # fits, but a bigger one may fit too, go right
            else:
                high = mid - 1  # too big, go left

        # loop ended: high is the last index with value <= target
        # if nothing fits, high is -1
        return high


# quick test
if __name__ == "__main__":
    s = Solution()
    forward = [[1, 2000], [2, 4000], [3, 6000]]
    backward = [[1, 2000]]
    target = 7000
    print(s.optimalAirRoute(forward, backward, target))  # expected: [[2, 1]]