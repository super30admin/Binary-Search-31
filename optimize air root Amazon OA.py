'''
Time Complexity: m =len(arr1), n=len(arr2)
    - mlogm: sorting arr1
    - nlogn: sorting arr2
    - mlogn: for each element in arr1, do binary search in arr2.
Space Complexity: O(1) - no auxilary space. 
'''
class Solution:
    def optimizeAirRoutes(self,arr1, arr2, target):
        arr1 = sorted(arr1, key=lambda x:x[1]) # sort based on cost
        arr2 = sorted(arr2, key=lambda x:x[1]) # sort based on cost
        
        optimized_routes = [] # [(pairs)])
        self.min_diff = 2**31-1

        for i in range(len(arr1)):
            if target-arr1[i][1]>=0:
                self.binarySearch(arr2,target-arr1[i][1],optimized_routes,arr1[i][0])
            else:
                break
        
        return optimized_routes[0]
    
    def binarySearch(self,arr2,revised_target,optimized_routes,forward_route):
        left = 0
        right = len(arr2)-1

        while left<=right:
            mid = left + (right-left)//2
            if arr2[mid][1]==revised_target: # exact match
                if self.min_diff!=0:
                    self.min_diff=0
                    if len(optimized_routes)!=0:
                        optimized_routes.pop() # remove the top element
                    optimized_routes.append([])
                    optimized_routes[0].append((forward_route,arr2[mid][0]))
                else:
                    # just append to 
                    optimized_routes[0].append((forward_route,arr2[mid][0]))
                return 
            elif arr2[mid][1]>revised_target:
                # overshoot the range, search in left range
                right = mid-1
            else:
                # maybe a possible answer. Check if diff is global minimum
                if revised_target-arr2[mid][1]<=self.min_diff:
                    # case 1: diff is same as global min, append the pair
                    if revised_target-arr2[mid][1]==self.min_diff:
                        optimized_routes[0].append((forward_route,arr2[mid][0]))
                    # case 2: diff is less then global min, clear the list. start fresh
                    else:
                        if len(optimized_routes)!=0:
                            optimized_routes.pop()
                        optimized_routes.append([])
                        optimized_routes[0].append((forward_route,arr2[mid][0]))
                    
                    self.min_diff=revised_target-arr2[mid][1] # update global min

                # try doing binary search in right space, to further reduce the difference
                left = mid+1                



mySolution = Solution()
print(mySolution.optimizeAirRoutes(
    arr1 = [(1, 2000),(2, 3000),(3, 4000)],
    arr2 = [(1, 5000),(2, 3000)],
    target = 5000)
)   # Answer -> [1,2]

target=10000
a=[[1,3000],[2,5000],[3,7000],[4,10000]]
b=[[1,2000],[2,3000],[3,4000],[4,5000]]
'''
Output: [[2, 4], [3, 2]]
'''
print(mySolution.optimizeAirRoutes(arr1=a,arr2=b,target=target))
