class Solution:
    def optimalAirRoute(self, forward, backward, target):
        result = []
        forward.sort(key=lambda a: a[1])
        backward.sort(key=lambda a: a[1])

        left = 0
        right = len(backward) - 1
        maxSum = 0

        while left < len(forward) and right >= 0:
            sum = forward[left][1] + backward[right][1]
            if sum > target:
                right -= 1
            else:
                if sum > maxSum:
                    result = []
                    maxSum = sum
                if sum == maxSum:
                    i = right
                    while i >= 0 and backward[i][1] == backward[right][1]:
                        result.append([forward[left][0], backward[i][0]])
                        i -= 1
                left += 1
        return result

    def main(self):
        s = Solution()
        forward = [[1, 2000], [2, 4000], [3, 6000]]
        backward = [[1, 2000]]
        target = 7000
        res = s.optimalAirRoute(forward, backward, target)
        for pair in res:
            print(str(pair[0]) + "," + str(pair[1]))

if __name__ == "__main__":
    Solution().main()
