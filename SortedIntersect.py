# time complexity is o(mlog(n)), where m, n is size of the input and m <= n
# space complexity is o(1)
def intersect(nums1, nums2):
    if(len(nums1) > len(nums2)):
        return intersect(nums2, nums1)
    low = 0
    high = len(nums2) - 1
    res = list()
    for i in nums1:
        ind = binarys(nums2, low, high, i)
        if(ind != -1):
            res.append(nums2[ind])
            low = ind + 1
    return res

def binarys(nums, low, high, target):
    while(low <= high):
        mid = low + (high - low)//2
        if(nums[mid] == target):
            if(mid == low or nums[mid] != nums[mid - 1]):
                return mid
            if(mid >= low and nums[mid] == nums[mid-1]):
                high = mid
        elif(nums[mid] < target):
            low = mid + 1
        else:
            high = mid - 1
    return -1


nums1 = [1,2,2,3,3,3,3,7,9,11,11,20]
nums2 = [2,3,3,5,6,8,11,21]
print(intersect(nums1, nums2)) #[2, 3, 3, 11]
