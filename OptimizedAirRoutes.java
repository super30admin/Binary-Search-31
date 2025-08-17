// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

public class OptimalRoutePairs {
  public static List<int[]> optimalRoutePairs(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
    List<int[]> result = new ArrayList<>();
    Map<Integer, List<Integer>> forwardMap = new HashMap<>();
    int maxDist = 0;

    // Build a map where the key is the distance and the value is a list of IDs with that distance
    for(int[] forwardRoute: forwardRouteList) {
      forwardMap.computeIfAbsent(forwardRoute[1], k -> new ArrayList<>()).add(forwardRoute[0]);
    }
    // Iterate over each return route
    for(int[] returnRoute: returnRouteList) {
      int returnID = returnRoute[0];
      int returnDist = returnRoute[1];
      // Get the distance that the forward route should be equal to or less than
      int targetDist = maxTravelDist - returnDist;
      for(int forwardDist: forwardMap.keySet()) {
        if(forwardDist <= targetDist) {
          int currentDist = returnDist + forwardDist;
          // Update maxDistance
          if(currentDist > maxDist) {
            maxDist = currentDist;
            result.clear();
          }
          if(maxDist == currentDist) {
            for(int forwardId: forwardMap.get(forwardDist)) {
              result.add(new int[]{forwardId, returnID});
            }
          }
        }
      }
    }
    return result;
  }
}