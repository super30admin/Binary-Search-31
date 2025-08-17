# a = [[1, 2], [2, 4], [3, 6]]
# b = [[1, 2]]
class Solution:
    def optimalUtilize(self, s1, s2, target):
        """using nearest binary search
        Time complexity-O(mlog(n))
        Space complexity-O(1)
        arr=[]
        maxval=0
        # if len(s1)>len(s2):
        #     return self.optimalUtilize(s2,s1, target)
        for i in s1:
            j=self.nearestBinarySearch(target-i[1], s2)
            print(i,j)
            if i[1]+j[1]>maxval and i[1]+j[1]<=target:
                arr.clear()
                maxval=i[1]+j[1]
                arr.append([i[0],j[0]])
            elif i[1]+j[1]==maxval and i[1]+j[1]<=target:
                arr.append([i[0],j[0]])
        print(arr)
        return arr

    
    def nearestBinarySearch(self, target, str):
        start=0
        end=len(str)-1
        while start<=end:
            mid=start+(end-start)//2
            if str[mid][1]==target:
                return str[mid]
            elif str[mid][1]<target:
                # print(str[start], str[mid-1], str[mid], str[mid+1],str[end])
                if mid<len(str)-1 and str[mid+1][1]>target:
                    return str[mid]
                else:
                    # print(":::")
                    start=mid+1
            else:
                # print(str[start], str[mid-1], str[mid], str[mid+1],str[end])
                if mid>0 and str[mid-1][1]<target:
                    return str[mid-1]
                else:
                    end=mid-1
        return str[mid]
        
        """Solution using 2 pointers
        Time complexity-O(m+n)
        Space complexity-O(1)"""
        # maxval=0
        # arr=[]
        # if len(s1)>len(s2):
        #     return self.optimalUtilize(s2,s1, target)
        # start=0
        # end=len(s2)-1
        # while start<len(s1) and end>=0:
        #     if s1[start][1]+s2[end][1]>target:
        #         end-=1
        #     else:
        #         if s1[start][1]+s2[end][1]>maxval:
        #             maxval=s1[start][1]+s2[end][1]
        #             arr.clear()
        #             arr.append([s1[start][0], s2[end][0]])
        #         elif s1[start][1]+s2[end][1]==maxval:
        #             arr.append([s1[start][0], s2[end][0]])
        #         start+=1
        # print(arr)
        # return arr

sol=Solution()
sol.optimalUtilize( [[1, 2], [2, 4], [3, 6]], [[1, 2]], 7)









