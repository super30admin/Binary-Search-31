# Optimized Routes
'''
Time Complexity: O(mlogn) where n is length of bigger array
Space Complexity: O(1)
'''

'''
Follow following pattern for Nearest Neighbour Binary Search
The Binary search (high) will give the element less than target while (beg) will be give element greater than or equal to target.
'''


def binarySearch(arr, n, id1):
    beg = 0
    end = len(arr)-1
    
    while(beg<=end):
        mid = (beg+end)//2
        if(arr[mid][1]>=n):
            end = mid - 1
        else:
            beg = mid + 1

    global output
    global min1
    '''
    Additional check to find whether there are element equal to target
    '''
    if(beg<len(arr) and arr[beg][1]==n):
        end = beg
    if(end>=0 and n-arr[end][1]>=0 and n-arr[end][1]<=min1):
        if(n-arr[end][1]<min1):
            output = []
        output.append([id1, arr[end][0]])
        min1 = n-arr[end][1]
        end +=1
        while(end<len(arr) and n-arr[end][1]==min1):
            output.append([id1, arr[end][0]])
        
    
    

def getAirTime(arr1, arr2, target):
    # arr1 is sorted
    for i in arr2:
        binarySearch(arr1, target-i[1], i[0])



def primeAirTime(forwardRoute, backwardRoute, target):
    if(len(forwardRoute)>len(backwardRoute)):
        forwardRoute.sort(key= lambda x:x[1])
        getAirTime(forwardRoute, backwardRoute, target)
        o = []
        for i in output:
            o.append([i[1],i[0]])
        return o
    else:
        backwardRoute.sort(key= lambda x:x[1])
        getAirTime(backwardRoute, forwardRoute, target)
        return output
        
output = []
min1 = float("inf")
print(primeAirTime([[1,2000],[2,3000],[3,4000]],[[1,5000],[2,3000]],5000))
output = []
min1 = float("inf")
print(primeAirTime([[1,2000],[2,4000],[3,6000]],[[1,2000]],7000))
output = []
min1 = float("inf")
print(primeAirTime([[1,2000],[2,4000],[3,6500],[4,8000]],[[1,3000],[2,4000],[3,6000],[4,7000]],8500))
