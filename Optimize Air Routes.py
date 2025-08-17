

def intersect(nums1, nums2, target):
    # if(len(nums1) > len(nums2)):
    #     return intersect(nums2, nums1,target)
    low = 0
    maxval = float('-inf')
    res = []
    high = len(nums2) - 1
    for i in nums1:
        ind = binarys(nums2, low, high, i[1],target)
        if(ind != -1):
            currval = nums2[ind][1] + i[1]
            if(currval <= target):
                if(currval > maxval):
                    maxval = currval
                    res = [[i[0], nums2[ind][0]]]
                else:
                    res.append([i[0], nums2[ind][0]])
    return res

                
def binarys(nums, low, high, val, target):
    maxval = float('-inf')
    mids = -1
    while(low <= high):
        mid = low + (high - low)//2
        currval = val + nums[mid][1]
        if(currval == target):
            return mid
        elif(currval > maxval and currval < target):
            maxval = currval
            mids = mid
        elif(currval < target):
            if(currval > maxval):
                maxval = currval
                mids = mid   
            low = mid + 1
        else:
            high = mid - 1
    return mids
        
a = [[1,2],[2,4],[3,6]]
b = [[1, 2]]
target = 7
print(intersect(a, b, target))


