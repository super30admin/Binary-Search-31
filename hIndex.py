"""
Since the list is sorted, we can apply binary search
At each mid, check if citations[mid] >= (n - mid)
If yes, move left; else move right
"""
"""
Time Complexity: O(log n)
Space Complexity: O(1)
"""

class hIndex:
    def hIndexCalculate(self, citations: list[int]) -> int:
        n = len(citations)
        low, high = 0, n - 1
        res = 0

        while low <= high:
            mid = (low + high) // 2
            if citations[mid] >= n - mid:
                res = n - mid
                high = mid - 1
            else:
                low = mid + 1

        return res

if __name__ == "__main__":
    obj = hIndex()

    citations1 = [0, 1, 3, 5, 6]
    print(obj.hIndexCalculate(citations1))

    citations2 = [0, 1, 4, 6, 7]
    print(obj.hIndexCalculate(citations2)) 

    citations3 = [0, 0, 0]
    print(obj.hIndexCalculate(citations3)) 
