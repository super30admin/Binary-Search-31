class Solution:
    #works for monotonic increasing lists;
    #will require slight changes for other input types
    def OptimalUtilization(self, forwardArr, returnArr, maxDist):
        #Approach: Linear + Binary Search
        #Time Complexity: O(min(m + log n, log m + n))
        #Space Complexity: O(1)
        
        m, n = len(forwardArr), len(returnArr)
        if m > n:
            resList =  self.OptimalUtilization(returnArr, forwardArr, maxDist)
            return [[k[1], k[0]] for k in resList]
        
        res = 0
        resList = []
        
        for p1 in range(m):
            p2 = self.BinarySearch(returnArr, maxDist - forwardArr[p1][1])
            if p2 == None:
                return resList
            
            if forwardArr[p1][1] + returnArr[p2][1] > res:
                res = forwardArr[p1][1] + returnArr[p2][1]
                resList = [[forwardArr[p1][0], returnArr[p2][0]]]
            elif forwardArr[p1][1] + returnArr[p2][1] == res:
                resList.append([forwardArr[p1][0], returnArr[p2][0]])
                
        return resList
    
    def BinarySearch(self, arr, target):  #returns closest smaller-equal; if no smaller, returns target
        low, high = 0, len(arr) - 1
        if target < arr[low][1]:
            return None
        
        while high - low > 1:
            mid = low + (high - low) // 2
            if arr[mid][1] == target:
                return mid
            elif arr[mid][1] > target:
                high = mid
            else:
                low = mid
        return high if high <= target else low
    
    """
    def OptimalUtilization(self, forwardArr, returnArr, maxDist):
        #Approach: Two pointers
        #Time Complexity: O(m + n)
        #Space Complexity: O(1)
        
        m, n = len(forwardArr), len(returnArr)
        p1 = 0
        p2 = n - 1
        
        res = 0
        resList = []
        while p1 < m and p2 >= 0:
            if forwardArr[p1][1] + returnArr[p2][1] > maxDist:
                p2 -= 1
            else:
                if forwardArr[p1][1] + returnArr[p2][1] > res:
                    res = forwardArr[p1][1] + returnArr[p2][1]
                    resList = [[forwardArr[p1][0], returnArr[p2][0]]]
                elif forwardArr[p1][1] + returnArr[p2][1] == res:
                    resList.append([forwardArr[p1][0], returnArr[p2][0]])
                p1 += 1
        return resList
    """

forwardArr = [[1, 3], [2, 5], [3, 7], [4, 10]]
returnArr = [[1, 2], [2, 3], [3, 4], [4, 5]]
maxDist = 10
    
sol = Solution()
res = sol.OptimalUtilization(forwardArr, returnArr, maxDist)
print(res)