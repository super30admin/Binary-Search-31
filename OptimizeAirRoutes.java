import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptimizeAirRoutes {
    public static void main(String[] args) {
        /*
        Question: given a list of forward routes and reverse routes and the maxTravelAllowed: return the most optimal pairs
        ex1: maxTravelDist = 10000
        forwardRouteList[] = [1,3000],[2,5000],[3,7000],[4,10000]
        returnRouteList[] = [1,2000],[2,3000],[3,4000],[4,5000]
        Op: [[2,4],[3,2]]

        ex2:
        maxTravelDist = 10000
        forwardRouteList[] = [1,3000],[2,5000],[3,7000]
        returnRouteList[] = [1,4000],[2,6000],[3,1000]
        Op: [[2,1],[3,2]]

        Here no pair has sum equal to 10000 but 2 pairs have 9000, so this will be the answer in this case.

        Approach: firstly did it in O(N^2) but it was giving TLE for half TCs.
        Then used 2 maps, first stored maxTravelDist - forwardRouteList[i][1] and second stored dist as key and index as values. Then iterate over fwdMap and find if same value is present in reverseMap.
        Couldn't pass all the TCs. 10/17 were passed.
        */


// Time Complexity : O(NLogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// First sort both the arrays based on the cost/miles
// Then use 2 pointers one from start and one from end. add it and compare it with the maxsum and also the given miles
// if its lesser increment i else decrement j, keep clearing the result array and adding it

        int[][] forwardRouteList = {
            {1, 3000},
            {2, 5000},
            {3, 7000},
            {4, 10000}
        };

        int[][] returnRouteList = {
            {1, 2000},
            {2, 3000},
            {3, 4000},
            {4, 5000}
        };

        int maxTravelDist = 10000;
        Arrays.sort(forwardRouteList, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(returnRouteList, Comparator.comparingInt(a -> a[1]));

        List<int[]> result = new ArrayList<>();
        int maxSum = -1;
        int i = 0, j = returnRouteList.length - 1;

        while (i < forwardRouteList.length && j >= 0) {
            int sum = forwardRouteList[i][1] + returnRouteList[j][1];
            if (sum > maxTravelDist) {
                j--;
            } else {
                if (sum > maxSum) {
                    maxSum = sum;
                    result.clear();
                    result.add(new int[] {forwardRouteList[i][0], returnRouteList[j][0]});
                } else if (sum == maxSum) {
                    result.add(new int[] {forwardRouteList[i][0], returnRouteList[j][0]});
                }
                i++;
            }
        }

        System.out.println("Optimal Pairs:");
        for (int[] pair : result) {
            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
        }
    }
}

