// Time Complexity : O(nlogn + mlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class Solution {
    public List<List<Integer>> optimalRoute(int maxTravelDist, int[][] forwardRoutes, int[][] returnRoutes) {
        List<List<Integer>> result = new ArrayList<>();

        if (forwardRoutes == null || forwardRoutes.length == 0 || returnRoutes == null || returnRoutes.length == 0) {
            return result;
        }

        Arrays.sort(forwardRoutes, (a, b) -> a[1] - b[1]);
        Arrays.sort(returnRoutes, (a, b) -> a[1] - b[1]);

        int maxDist = 0;

        for (int i = 0; i < forwardRoutes.length; i++) {

            int remainingDist = maxTravelDist - forwardRoutes[i][1];
            int index = binarySearch(returnRoutes, remainingDist);

            if (index == -1) continue;
            int total = forwardRoutes[i][1] + returnRoutes[index][1];

            if (total > maxDist) {

                maxDist = total;
                result = new ArrayList<>();
                result.add(new ArrayList<>(Arrays.asList(forwardRoutes[i][0], returnRoutes[index][0])));

            } else if (total == maxDist) {

                List<Integer> route = new ArrayList<>();
                route.add(forwardRoutes[i][0]);
                route.add(returnRoutes[index][0]);
                result.add(route);

            }
        }
        return result;
    }

    private int binarySearch(int[][] routes, int target) {
        int low = 0;
        int high = routes.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (routes[mid][1] == target) {
                return mid;
            } else if (routes[mid][1] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}