
"""
https://leetcode.com/discuss/interview-question/1025705/Amazon-or-OA-or-Prime-Air-time/824897

similar to two sum, but we cannot use hashmap as we dont need the exact sum, we need the nearest
m*n solution : for every element in forward, we check the sum with all elements in B and see for other pairs equal to the nearest sum obtained at the first place

O((m*n))

M2

Two Pointer : if the arrays are sorted  we point to first of F and last of B  and keep checking the sum if it is close to the target sum
TC = O(m+n)

M3 
binary search

For every element(distance) in F, we look for a value which is closest to (target - element in F) in B and maintain total distance for that combination
whenever we find a pair resulting into new total distance, that will be our new total distance to look for



"""


a = [(0,1000), (1,1500), (2,2000), (3,3000), (4,4500), (5,5000)]
b = [(0,1500),(1,2500),(2,3000),(3,3500),(4,4000),(5,5000)]
target = 7200
#we are taking arrays sorted on distance
# so we can do binary search on elements


class Solution():

    def bestRoute(self, a,b,target):
        # sorting the given forward and backward route wrt distance
        a.sort(key = lambda x:x[1])
        b.sort(key = lambda x:x[1])
        # set 2 pointers at start of forward route list and end of backward route list
        l = 0
        r = len(b)-1
        
        currDiff = float('inf')
         # Until we fully traverse through both the lists
        while l<len(a) and r>=0:
            id1, d1 = a[l]
            id2, d2 = b[r]
            
            if target -d1-d2 == currDiff:
                result.append([id1, id2])
            elif d1+d2<target and target-d1-d2<currDiff:
                result = []
                result.append([id1, id2])
                currDiff = target-d1-d2
                    
                    
        # Move the pointers until we find the optimal routes
            if target>d1+d2:
                l+=1
            else:
                r-=1
            
            
        return result
                    
obj = Solution()
ans = obj.bestRoute(a,b,target)
print(ans)
        
    