class Solution:
    def optimizeRoute(self,maxTravelDist,forwardRouteList,returnRouteList):
        result=[]
        maxUsed=-1

        for f_id,f_dist in forwardRouteList:
            for r_id,r_dist in returnRouteList:
                total=f_dist+r_dist
                if total>maxTravelDist:
                    continue
                if total>maxUsed:
                    maxUsed=total
                    result=[[f_id,r_id]]
                elif total==maxUsed:
                    result.append([f_id,r_id])

        return result if result else[[]]

sol=Solution()
maxTravelDist=7000
forwardRouteList=[[1,2000],[2,4000],[3,6000]]
returnRouteList=[[1,2000]]

print(sol.optimizeRoute(maxTravelDist,forwardRouteList,returnRouteList))