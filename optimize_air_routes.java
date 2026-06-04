// Time Complexity : O(f log f + r log r) where f and r are the sizes of forward and return route lists due to sorting
// Space Complexity : O(1) excluding the result list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We sort both route lists by distance and use Two Pointers to find the route pair with the largest travel distance not exceeding maxTravelDist.
// If the current total distance exceeds the limit, we move the return pointer left to reduce the sum.
// Otherwise, we update the answer if the current pair is better and move the forward pointer right to explore larger valid distances.

class Solution {
    public List<List<Integer>> optimalUtilization(int maxTravelDist,
                                                  List<List<Integer>> forwardRouteList,
                                                  List<List<Integer>> returnRouteList) {

        List<List<Integer>> result = new ArrayList<>();

        // sort routes by distance
        Collections.sort(forwardRouteList, (a, b) -> a.get(1) - b.get(1));
        Collections.sort(returnRouteList, (a, b) -> a.get(1) - b.get(1));

        int i = 0;
        int j = returnRouteList.size() - 1;
        int best = -1;

        while(i < forwardRouteList.size() && j >= 0) {

            int sum = forwardRouteList.get(i).get(1) +
                      returnRouteList.get(j).get(1);

            // current pair exceeds limit
            if(sum > maxTravelDist) {
                j--;
            } else {

                // better answer found
                if(sum > best) {
                    best = sum;
                    result.clear();
                }

                // same optimal answer
                if(sum == best) {
                    result.add(Arrays.asList(
                        forwardRouteList.get(i).get(0),
                        returnRouteList.get(j).get(0)
                    ));
                }

                i++;
            }
        }

        return result;
    }
}