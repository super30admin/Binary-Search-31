import java.util.*;

// linearOptimisedAirRoutes - Time: O(MN)  | Space : O(No of distinct sums of distance betweeen forward and backward * No of combination of routes))
// optimisedAirRoutes - Time: O(MLogN)  | Space : O(No of distinct sums of distance betweeen forward and backward * No of combination of routes))

public class OptimizationOfAirRoutes {
    public static List<List<Integer>> linearOptimisedAirRoutes(int[][] forward, int[][] backward, int target) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int bestMax = Integer.MIN_VALUE;
        for(int i=0;i< forward.length;i++) {
            int[] curr = forward[i];
            // escaping the duplicate from forward
            if(i>0 && curr[0] == forward[i-1][0] && curr[1] == forward[i-1][1]) continue;
            for(int j=0;j< backward.length;j++) {
                // escaping the duplicate in backward
                if(j>0 && backward[j][0] == backward[j-1][0] && backward[j][1] == backward[j-1][1]) continue;
                int currBest = curr[1]+backward[j][1];
                // if currBest is not equal to prev best, we ignore and move on
                if(currBest >= bestMax) {
                    if(currBest <= target) {
                        bestMax = currBest;
                        // if the entry for the currBest is already there, then we add the route to our result list
                        if(!map.containsKey(currBest)) {
                            map.put(currBest, new ArrayList<>());
                        }
                        List<Integer> currRoutes = new ArrayList<>();
                        currRoutes.add(curr[0]);
                        currRoutes.add(backward[j][0]);
                        map.get(currBest).add(currRoutes);
                    }
                }
            }
        }
        return map.get(bestMax);
    }
    public static List<List<Integer>> binarySearchoptimisedAirRoutes(int[][] forward, int[][] backward, int target) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int bestMax = Integer.MIN_VALUE;
        for(int i=0;i<forward.length;i++) {
            int[] curr = forward[i];
            // skipping the iteration in case of dupicates
            if(i>0 && curr[0] == forward[i-1][0] && curr[1] == forward[i-1][1]) continue;
            int low =0;
            int high = backward.length -1;
            while(low<=high) {
                int mid = low+(high-low)/2;
                int[] currBack = backward[mid];
                int currBest = curr[1]+currBack[1];
                if(currBest <= target) {
                    bestMax = currBest;
                    if(!map.containsKey(currBest)) {
                        map.put(currBest, new ArrayList<>());
                    }
                    List<Integer> currRoutes = new ArrayList<>();
                    currRoutes.add(curr[0]);
                    currRoutes.add(currBack[0]);
                    map.get(currBest).add(currRoutes);
                }

                if(currBest <= target) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }

        }
        return map.get(bestMax);
    }

    public static void main(String[] args) {
        int[][] arr1 = { {1, 2000}, {1,2000},{2, 3000}, {3, 4000} };
        int[][] arr2 = { { 1, 5000 }, {2, 3000}, {2, 3000} };
        // Assuming we will receive the air routes in the sorted manner upon the distance
        Arrays.sort(arr1, (a, b) -> a[1]-b[1]);
        Arrays.sort(arr2, (a, b) -> a[1]-b[1]);
        System.out.println(binarySearchoptimisedAirRoutes(arr1, arr2, 7000)); // [[1, 1], [3, 2]]
        System.out.println(linearOptimisedAirRoutes(arr1, arr2, 7000)); // [[1, 1], [3, 2]]
    }
}
