#Route optimization
# Time complexity = O(nlogn + mlogn) where n is the longer list len and m is of smaller
# space complexity = O1
class Solution:
    def solution(self, maxTravelDist, forwardRouteList, returnRouteList):
        fwd, rtn = -1, -1

        # since soute2 list needs to be sorted, pass longer list as route 2 list
        if len(forwardRouteList) > len(returnRouteList):
            rtn, fwd = self.optimizeRoute(maxTravelDist, returnRouteList, forwardRouteList)
        else:
            fwd, rtn = self.optimizeRoute(maxTravelDist, forwardRouteList, returnRouteList)
        
        if fwd == -1:
            return []
        return [[fwd, rtn]]


    def optimizeRoute(self, maxTravel, routeList1, routeList2):
        result = [-1, -1]
        routeList2.sort(key = lambda x:x[1])

        minRemainignCapacity = maxTravel

        for index, travel in routeList1:
            if travel < maxTravel:
                remoainingCapacity = maxTravel - travel
                index2, remiainigCapacity = self.findRemainingCapacityIndex(remoainingCapacity, routeList2)
                if index2 != -1:
                    if remiainigCapacity == 0:
                        return index, index2
                    if remiainigCapacity < minRemainignCapacity:
                        minRemainignCapacity = remiainigCapacity
                        result = [index, index2]
        return result


    
    def findRemainingCapacityIndex(self, remoainingCapacity, routeList2):


        l = 0
        h = len(routeList2)-1
        if routeList2[l][1]>remoainingCapacity:
            return -1, remoainingCapacity
        if routeList2[h][1] < remoainingCapacity:
            return routeList2[h][0] , remoainingCapacity-routeList2[h][1]
        
        while l<h:
            mid = l+(h-l+1)//2

            midval = routeList2[mid][1]
            if midval == remoainingCapacity:
                return routeList2[mid][0], 0

            if midval>remoainingCapacity:
                h=mid-1
            else:
                l = mid
        
        return routeList2[l][0] , (remoainingCapacity-routeList2[l][1])
    


sol = Solution()

maxTravelDist = 5000
forwardRouteList = [[1,2000],[2,3000],[3,2000]]
returnRouteList = [[1,5000], [2, 3000]]
print(sol.solution(maxTravelDist, forwardRouteList, returnRouteList))