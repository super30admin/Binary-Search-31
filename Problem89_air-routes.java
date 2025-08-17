// TC : O(m log m + n log n)
// SC : O(1)
import java.util.*;
class Solution {
    public List<int[]> getPairs(List<int[]> forwardRouteList, List<int[]> returnRouteList, int maxTravelDis) {
        List<int[]> result = new ArrayList<>();
        Collections.sort(forwardRouteList, (i, j) -> i[1] - j[1]);
        Collections.sort(returnRouteList, (i, j) -> i[1] - j[1]);
        int max = Integer.MIN_VALUE;
        int m = forwardRouteList.size();
        int n = returnRouteList.size();
        int i = 0; 
        int j = n - 1;
        while(i < m && j >= 0) {
            int sum = a.get(i)[1] + returnRouteList.get(j)[1];
            if(sum > maxTravelDis) {
                --j;
            } else {
                if(max <= sum) {
                    if(max < sum) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[] {forwardRouteList.get(i)[0], returnRouteList.get(j)[0]});
                    int index = j - 1;
                    while(index >= 0 && returnRouteList.get(index)[1] == returnRouteList.get(index + 1)[1]) {
                        result.add(new int[] {forwardRouteList.get(index)[0], returnRouteList.get(index + 1)[0]});
                        index--;
                    }
                }
                i++;
            }
        } 
        return result;
    }
}