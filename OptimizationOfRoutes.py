#Time Complexity: O(mlogm) + O(nlogn) + O(nlogm)
#Space Complexity: O(1)

class Solution:
    def OptimizedAir1(self,maxDist, forwardList, backwardList):
        forwardList.sort(key = lambda x:x[1])
        backwardList.sort(key = lambda x:x[1])
        result = []
        maximum = -1
        for i in forwardList:
            rem = maxDist - i[1]
            index = self.binarySearch(rem,backwardList)
            if index!=-1:
                distCovered = i[1]+backwardList[index][1]
                if distCovered>=maximum:
                    if distCovered>maximum:
                        result = []
                        maximum = distCovered
                    result.append([i[0],backwardList[index][0]])
        return result
    
    def binarySearch(self,dist,arr):
        low = 0
        high = len(arr)-1
        nearest = -1
        while low<=high:
            mid = (low+high)//2
            if arr[mid][1]==dist:
                return mid
            elif dist<arr[mid][1]:
                high = mid-1    
            else:
                low = mid+1
                nearest = mid
        return nearest

if __name__ == '__main__':



	oa = Solution()



	print(oa.OptimizedAir1(7000, [[1,2000],[2,4000],[3,6000]], [[1,2000]]))



	print(oa.OptimizedAir1(10000, [[1,3000],[2,5000],[3,7000],[4,10000]], [[1,2000],[2,3000],[3,4000],[4,5000]]))



	