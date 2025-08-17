"""
Problem : 1

Time Complexity : 
Bruteforce - O(n^2)
Two Pointers - O(nlogn)

Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Bruteforce - 
first sorting the input arrays, and initializing a maxx variable which would store the maximum value of sum of distances travelled (or fuel used) both sides
less than or equal to the target, iterating over each airRoute going forward and coming backwards, checking if the total trip distance is greater than maxx and
within the target, updating the target, and adding the routeID to the distance key in hashmap, this would help in getting multiple optimal routes with same trip distance
in constant time

Two Pointer - 
Initiliazing two pinters, one at the start of the forward route array and one at the end of backward route array, if the total trip distance falls within target
increamenting the start pointer to get a bigger sum, then updating the maxx varibale and updating values in hashmap, if not, decrementing the end pointer,
breaking the loop if any of the pointers go out of bounds, and returning the routeIDs at the maxx trip distance occured for the entire trip, returning the routeIDs
for the maximum trip distance

"""

# Optimize Air Routes

# Approach - 1
# Bruteforce



class airRoutes(object):
    
    def optRouteDist(self,a,b,target):
        hmap={}
        a.sort(key=lambda x:x[1])
        b.sort(key=lambda x:x[1])

        
        maxx=0
        for fwd in a:
            for bwd in b:
                trip=fwd[1]+bwd[1]
                if trip<=target and trip>=maxx:
                    maxx=trip
                    if not maxx in hmap:
                        hmap[maxx]=[]
                    hmap[maxx].append([fwd[0],bwd[0]])
        idd=hmap[maxx]
        if idd:
            return idd
        else:
            return []



# Approach - 2
# Bruteforce - Two Pointers

class airRoutes(object):
    
    def optRouteDist(self,a,b,target):
        hmap={}
        a.sort(key=lambda x:x[1])
        b.sort(key=lambda x:x[1])
        
        maxx=0
        l=0
        r=len(b)-1
        
        while l<len(a) and r>=0:
            trip=a[l][1]+b[r][1]
            if trip<=target:
                maxx=max(trip,maxx)
                if not maxx in hmap:
                    hmap[maxx]=[]
                hmap[maxx].append([a[l][0],b[r][0]])
                l+=1
            else:
                r-=1
        idd=hmap[maxx]
        if idd:
            return idd
        else:
            return []
        

ar=airRoutes()    
a = [[1, 8], [2, 15], [3, 9]]
b = [[1, 8], [2, 11], [3, 12]]
target = 20

print(ar.optRouteDist(a,b,target))