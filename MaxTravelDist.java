import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Puri
 * // Time Complexity : O(m+n)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class MaxTravelDist {
    public List<List<Integer>> maxTravelDist(List<List<Integer>> forward, List<List<Integer>> returnRoute, int maxDistance) {
        List<List<Integer>> res = new ArrayList<>();
        int currMax = Integer.MIN_VALUE;
        if (forward == null || returnRoute == null) return res;
        int start = 0, end = returnRoute.size() - 1;
        while (start == forward.size() || end < 0) {
            int tempDist = forward.get(start).get(1) + returnRoute.get(end).get(1);
            if (tempDist > maxDistance) {
                end--;
            } else if (tempDist < currMax) {
                start++;
            } else if (tempDist > currMax) {
                res = new ArrayList<>();
                res.add(forward.get(start));
                res.add(returnRoute.get(end));
                start++;
            } else if (tempDist == currMax) {
                res.add(forward.get(start));
                res.add(returnRoute.get(end));
                start++;
                end--;
            }
        }
        return res;
    }

}
