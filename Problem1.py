"""
Time complexity - O(nlogn)
Space Complexity - O(1)
Here we have defined two functions
Optimal Route-
In this function we are sorted one array wrt to their weights.Then taking one element from second array performing BST to get value equal to target or almost equal to target.
calculate the total sum if total sum is more than target then clear previous value and put new values or equal to target then append in previous value
Binary Search-
Target value and sorted array is passed to this function finding mid and comparing with target and accordingly changing values of low and high so as to get less and near to target value output.
"""
class Solution:
    def OptimalRoute(self,array1,array2,target):
        output = []
        array1.sort(key=lambda x:x[1])
        max = float("-inf")
        for i in range(len(array2)):
            index = self.BinarySearch(array1,target-array2[i][1])
            if index != -1:
                sum = array2[i][1] + array1[index][1]
                if sum > max:
                    output = []
                    max = sum
                output.append([array1[index][0],array2[i][0]])
        return output

    def BinarySearch(self,nums,target):
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid = low + ((high-low)//2)
            if nums[mid][1] == target:
                return mid
            elif nums[mid][1] < target:
                low = mid+1
            else:
                high = mid-1
        return high

s1 = Solution()
array1 = [[1,2000],[2,4000],[3,6000]]
array2 = [[1,2000],[2,4000],[3,6000]]
target = 7000
res = s1.OptimalRoute(array1,array2,target)
print(res)
