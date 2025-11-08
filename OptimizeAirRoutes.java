// Time Complexity : O(n log n + m log m) sorting + O(m+n) two pointer traversal
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// sort both the arrays based on the distance values
// Use two pointer to check optimal pairs
// If optimal pair found add to result list and check for other pairs in backward array with same distance value

public class OptimizeAirRoutes {
    public List<int[]> optimalAirRoute(int[][] forward, int[][] backward, int target) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(forward, (a, b) -> a[1] - b[1]);
        Arrays.sort(backward, (a, b) -> a[1] - b[1]);

        int l = 0; int r = backward.length - 1;
        int max = Integer.MIN_VALUE;
        while(l < forward.length && r >= 0){
            int sum = forward[l][1] + backward[r][1];
            if(sum > target){
                r--;
            } else {
                if(sum >= max){
                    if(sum > max){
                        result.clear();
                        max = sum;
                    }
                    result.add(new int[]{forward[l][0], backward[r][0]});
                    // adding all the index with same values in backward array
                    int index = r - 1;
                    while(index >= 0 && backward[index][1] == backward[r][1]){
                        result.add(new int[]{forward[l][0], backward[index][0]});
                        index--;
                    }
                }
                l++;
            }
        }
        return result;
    }
}
