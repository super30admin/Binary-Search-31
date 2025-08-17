# Approach : Two pointer solution using sorting of arrays
# TC O(m+n) if arrays are sorted else O(mlogm + nlogn) to sort arrays
# SC O(1)
def optimumRoutes(arr1, arr2, target):
    ans = []
    arr1.sort(key = lambda x: x[1])
    arr2.sort(key = lambda x: x[1])

    p1, p2 = 0, len(arr2)-1
    currMax = 0
    while p1 < len(arr1) and p2 >= 0:
        if arr1[p1][1] + arr2[p2][1] <= target:
            if currMax < (arr1[p1][1] + arr2[p2][1]):
                ans = []
                currMax = max(currMax, (arr1[p1][1] + arr2[p2][1]))
            ans.append([arr1[p1][0], arr2[p2][0]])
            p1 += 1
        else:
            p2 -= 1
    return ans

import unittest
class TestMinDist(unittest.TestCase):
    def test_generic(self):
        self.assertEqual([[2,4],[3,2]], optimumRoutes([[1,3000],[2,5000],[3,7000],[4,10000]], [[1,2000],[2,3000],[3,4000],[4,5000]], 10000))
        self.assertEqual([], optimumRoutes([[1,3000],[2,5000],[3,10000],[4,10000]], [[1,10000],[2,10000],[3,10000],[4,10000]], 10000))
        self.assertEqual([[3, 1]], optimumRoutes([[1, 8], [2, 7], [3, 14]], [[1, 5], [2, 10], [3, 14]], 20))

if __name__ == "__main__": unittest.main()