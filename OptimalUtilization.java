//T.C :  O(mlogm) + O(nlogn) ; m is no of elements in forwardRoutes , n is no of elements in returnRoutes
//S.C: O(1)
import java.util.*;

public class OptimalUtilization {
    public static void main(String[] args) {

            OptimalAirRoute obj = new OptimalAirRoute();
            int[][] forwardRoutes = { { 1, 1000 }, { 2, 2000 }, { 3, 3000 }, { 4, 4500 }, { 5, 6000 } };
            int[][] returnRoutes = { { 1, 2000 }, { 2, 3500 }, { 3, 4500 }, { 4, 6500 } };
            int maxDistance = 7000;

            List<List<Integer>> optimalRoutePair = obj.optimalRoute(maxDistance, forwardRoutes, returnRoutes);
            for (List<Integer> l1 : optimalRoutePair) {
                for (Integer n : l1) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }

    }
}

class OptimalAirRoute {
    public List<List<Integer>> optimalRoute(int maxDistance, int[][] forwardRoutes,  int[][] returnRoutes) {
        int low = 0;
        int high = returnRoutes.length -1;
        int sum = Integer.MIN_VALUE;
        Arrays.sort(forwardRoutes , (a,b) -> a[1]-b[1]);
        Arrays.sort(returnRoutes , (a,b) -> a[1]-b[1]);

        List<List<Integer>> result = new ArrayList<>();
        while(low < forwardRoutes.length && high >=0) {
            int currentSum = (forwardRoutes[low][1]+returnRoutes[high][1]);
            if (currentSum > maxDistance) {
                high--;
            } else if (currentSum == maxDistance) {
                result.clear();
                result.add(Arrays.asList(
                    forwardRoutes[low][0], returnRoutes[high][0]));
                high--;
            } else {
                int oldSum = sum;
                sum = Math.max(sum, currentSum);
                if (oldSum < sum ) {
                    result.clear();
                    result.add(Arrays.asList(
                            forwardRoutes[low][0], returnRoutes[high][0]));
                } else if (oldSum == sum) {
                    result.add(Arrays.asList(
                            forwardRoutes[low][0], returnRoutes[high][0]));
                }
                low++;
            }
        }
        return result;
    }
}