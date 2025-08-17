class Solution:
    def optimalR(self, target, forwardR, returnR) :

        result=[]
        reverseD=0
        maxD=0

        if forwardR==None or len(forwardR)==0 or returnR==None or len(returnR)==0:
            return result
        #sort forwardR and returnR

        for i in range(0,len(forwardR)):
            reverseD=target-forwardR[i][1]
            index=self.BinarySearch(returnR,reverseD)
            if index==-1:
                continue

            total=forwardR[i][1]+returnR[index][1]
            if total>maxD:
                maxD=total
                result=[]
            if total==maxD:
                result.append([forwardR[i][0]],returnR[index][0])
        return result


    def BinarySearch(self,route,target):

        low=0
        n=len(route)
        high=n-1

        while low<=high:
            mid=low+(high-low)//2
            if route[mid][1]==target:
                return mid
            elif route[mid]<target:
                low=mid+1
            else :
                high=mid-1
        return high

