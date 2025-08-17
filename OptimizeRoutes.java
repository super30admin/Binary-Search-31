/*
def optimizeAirRoutes(forwardR, returnR, maxDist):
    if len(forwardR) == 0 or len(returnR) == 0 or maxDist == 0:
        return []
        
    def binary(arr, complement):
        low = 0
        high = len(arr) - 1
        prev = -1
        while low <= high:
            mid = low + (high - low)//2
            if arr[mid][1] == complement:
                return mid
            elif arr[mid][1] < complement:
                prev = mid
                low = mid + 1
            else:
                high = mid - 1
        
        if arr[prev][1] > complement:
            return -1
        return prev
        
    result = []
    returnR.sort(key = lambda x:x[1])
    forwardR.sort(key = lambda x:x[1])
    for i in range(len(returnR)):
        complement = maxDist - returnR[i][1]
        index = binary(forwardR, complement)

        if index != -1:
            result.append((forwardR[index][0], returnR[i][0]))
            
    return result

maxTravelDist = 8000
forwardRouteList = [[1,2000],[2,4000],[3,6000]]

returnRouteList = [[1,2000], [2,5000]]
print(optimizeAirRoutes(forwardRouteList, returnRouteList, maxTravelDist))
*/


// Time - O(mlogn) m and n are size of two lists + O(nlogn + mlogm) for sorting
// Space - O(1)
// Logic - Sorted both lists and then iterated through return list and performed binary search on forward list

import java.util.*;
class OptimizeRoutes{
    public static List<List<Integer>>  optimizeAirRoutes(int[][] forwardR, int[][] returnR, int maxDist){
        List<List<Integer>> result = new ArrayList<>();
        if (forwardR.length == 0 || returnR.length == 0 || maxDist == 0)
            return result;

        Arrays.sort(forwardR, (a,b)-> a[1] - b[1]);
        Arrays.sort(returnR, (a,b)-> a[1] - b[1]);

        for (int i=0; i<returnR.length; i++){
            int complement = maxDist - returnR[i][1];
            int index = binary(forwardR, complement);

            if (index != -1){
                List<Integer> temp = new ArrayList<>();
                temp.add(forwardR[index][0]);
                temp.add(returnR[i][0]);
                result.add(temp);
            }
                
        }
        return result;
    }
    private static int binary(int[][] arr, int complement) {
        int low = 0;
        int high = arr.length - 1;
        int prev = -1;
        while (low <= high){
            int mid = low + (high-low)/2;
            if (arr[mid][1] == complement)
                return mid;

            else if (arr[mid][1] < complement){
                prev = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }

        if (arr[prev][1] > complement)
            return -1;

        return prev;
    }
    public static void main(String args[]){
        int[][] f = {{1, 2000}, {2, 4000}, {3, 6000}};
        int[][] b = {{1, 2000}, {2, 5000}};
        int max = 8000;
        //optimizeAirRoutes(f, b, max);
        System.out.println(optimizeAirRoutes(f, b, max));
    }
}