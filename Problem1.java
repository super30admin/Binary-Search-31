import java.util.Arrays;

/*
Optimize Air-routes
approach: for each element in smaller array, find close element of target-arr1[i]
time: O(m log m + n log m)
space: O(1)
 */
public class Problem1 {
    private int[] optimizeRoutes(int[][] forwardRoutes, int[][] returnRoutes, int capacity){
        if (forwardRoutes.length>returnRoutes.length) return optimizeRoutes(returnRoutes, forwardRoutes, capacity);
        int max = 0;
        int[] result = new int[2];
        Arrays.sort(returnRoutes, (a,b)->(a[1]-b[1]));
        for(int[] route: forwardRoutes) {
            int target = Math.abs(route[1]-capacity);
            int[] pair = findPair(returnRoutes, target);
            if (pair[0]!=-1 && pair[1]!=-1) {
                int curMax = route[1]+pair[1];
                if (curMax<=capacity) {
                    if (curMax>max) {
                        result[0] = route[0];
                        result[1] = pair[0];
                    }
                }
            }
        }


        return result;
    }

    private int[] findPair(int[][] returnRoutes, int target) {
        int l = 0, h = returnRoutes.length;
        if (target<returnRoutes[0][1]) return returnRoutes[0];
        if (target>returnRoutes[returnRoutes.length-1][1]) return returnRoutes[returnRoutes.length-1];

        while (l<=h) {
            int m = l+(h-l)/2;

            if (returnRoutes[m][1]==target) return returnRoutes[m];
            else if (returnRoutes[m][1]<target) l = m+1;
            else h = m-1;
        }

        return Math.abs(target-returnRoutes[l][1])<Math.abs(target-returnRoutes[h][1])?returnRoutes[l]:returnRoutes[h];
    }

    public static void main(String []args) {
        Problem1 problem1 = new Problem1();
        problem1.optimizeRoutes(new int[][]{ {1, 2000}, {2, 4000}, {3, 6000} }, new int[][]{{ 1, 2000 }},7000);
    }
}
