#Binary Search
""""// Time Complexity : O(mlog(n)) m->small array, n->large array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def optimalUtilization(self, a, b, target):
        # if len(a) > len(b):
        #     return self.optimalUtilization(b, a, target)
        maximum=float('-inf')
        for i in range(len(a)):
            findnear=target-a[i][1]
            value= self.binarySearch(b,findnear)
            temp=a[i][1]+value[1]
            if temp<=target:
                if temp>maximum:
                    maximum=temp
                    result=[]
                    result.append([a[i][0], value[0]])
                elif temp==maximum:
                    result.append([a[i][0], value[0]])
        return result

    def binarySearch(self, b, x):
        low=0
        high=len(b)-1

        while low<high:
            mid=low+(high-low)//2
            if b[mid][1]==x:
                return b[mid]
            elif b[mid][1]<x and b[mid+1][1]<x:
                low=mid+1
            else:
                high=mid
        return b[low]

Obj = Solution()
print(Obj.optimalUtilization([[0, 1000], [1, 1500], [2, 2000], [3, 3000], [4, 4500], [5, 6000]], [[0, 1500], [1, 2500], [2, 3000], [3, 3500], [4, 4000], [5, 5000]], 7200))
# print(Obj.optimalUtilization([[1, 2], [2, 4], [3, 6]], [[1, 2]], 7))




#2-pointers
""""// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def optimalUtilization(self, a, b, target):
#         maximum=float('-inf')
#         result=[]
#         p1=0
#         p2=len(b)-1
#         while p1<len(a) and p2>-1:
#             temp=a[p1][1]+b[p2][1]
#             if temp <= target:
#                 if temp > maximum:
#                     maximum = max(maximum, temp)
#                     result = []
#                     result.append([a[p1][0], b[p2][0]])
#                 elif temp==maximum:
#                     maximum = max(maximum, temp)
#                     result.append([a[p1][0], b[p2][0]])
#                 if a[p1][1] <= b[p2][1]:
#                     p1 += 1
#                 elif a[p1][1] > b[p2][1]:
#                     p2 -= 1
#             elif temp>target:
#                 p2-=1
#         return result
#
# Obj = Solution()
# print(Obj.optimalUtilization([[0, 1000], [1, 1500], [2, 2000], [3, 3000], [4, 4500], [5, 6000]], [[0, 1500], [1, 2500], [2, 3000], [3, 3500], [4, 4000], [5, 5000]], 7200))
# print(Obj.optimalUtilization([[1, 2], [2, 4], [3, 6]], [[1, 2]], 7))






#Brute Force
""""// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
# class Solution:
#     def optimalUtilization(self, a, b, target):
#         maximum=float('-inf')
#         result=[]
#         for i in range(len(a)):
#             for j in range(len(b)):
#                 temp=a[i][1]+b[j][1]
#                 if temp <= target and temp > maximum:
#                     maximum = max(maximum, temp)
#                     result=[]
#                     result.append([a[i][0], b[j][0]])
#                 elif temp<=target and temp>=maximum:
#                     maximum=max(maximum, temp)
#                     result.append([a[i][0], b[j][0]])
#
#         return result
#
#
# Obj = Solution()
# print(Obj.optimalUtilization([[0, 1000], [1, 1500], [2, 2000], [3, 3000], [4, 4500], [5, 6000]], [[0, 1500], [1, 2500], [2, 3000], [3, 3500], [4, 4000], [5, 5000]], 7200))
# # print(Obj.optimalUtilization([[1, 2], [2, 4], [3, 6]], [[1, 2]], 7))