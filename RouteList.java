import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> optimalUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(forwardRouteList, (a, b) -> a[1] - b[1]);
        Arrays.sort(returnRouteList, (a, b) -> a[1] - b[1]);
        int maxDist = -1;
        int i = 0, j = returnRouteList.length - 1;
        while (i < forwardRouteList.length && j >= 0) {
            int currDist = forwardRouteList[i][1] + returnRouteList[j][1];
            if (currDist > maxTravelDist) {
                j--;
            } else {
                if (currDist >= maxDist) {
                    if (currDist > maxDist) {
                        result.clear();
                        maxDist = currDist;
                    }
                    result.add(Arrays.asList(forwardRouteList[i][0], returnRouteList[j][0]));
                    int k = j - 1;
                    while (k >= 0 && returnRouteList[k][1] == returnRouteList[j][1]) {
                        result.add(Arrays.asList(forwardRouteList[i][0], returnRouteList[k][0]));
                        k--;
                    }
                    j = k;
                } else {
                    i++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int maxTravelDist = 7000;
        int[][] forwardRouteList = {{1, 2000}, {2, 4000}, {3, 6000}};
        int[][] returnRouteList = {{1, 2000}};

        Solution solution = new Solution();
        List<List<Integer>> result = solution.optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList);
        System.out.println(result); // [[2, 1]]
    }
}
