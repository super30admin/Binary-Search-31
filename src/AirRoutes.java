import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author Aditya Sinha
 *
 * sort both forward and backward routes by distance to make searching easier
 * use two pointers — one from the start of forward, one from the end of backward — and try combinations without going over the target.
 * whenever we hit the best possible sum, we collect all matching pairs that give us that value
 * Time Complexity - O(n log n + m log m) + O(n + m)
 * Space Complexity - O(1)
 * 
 */
public class AirRoutes {

	public List<int[]> optimalAirRoute(int[][] forward, int[][] backward, int target) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(forward, (a, b) -> a[1] - b[1]); // O(n log n)
        Arrays.sort(backward, (a, b) -> a[1] - b[1]); // O(m log m)

        int left = 0;
        int right = backward.length - 1;
        int maxSum = 0;

        while (left < forward.length && right >= 0) {
            int sum = forward[left][1] + backward[right][1];
            if (sum > target) {
                right--;
            } else {
                if (sum > maxSum) {
                    result = new ArrayList<>();
                    maxSum = sum;
                }
                if (sum == maxSum) {
                    int i = right;
                    while (i >= 0 && backward[i][1] == backward[right][1]) {
                        result.add(new int[]{forward[left][0], backward[i][0]});
                        i--;
                    }
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    	AirRoutes ar = new AirRoutes();
        int[][] forward = {{1, 2000}, {2, 4000}, {3, 6000}};
        int[][] backward = {{1, 2000}};
        int target = 7000;
        List<int[]> res = ar.optimalAirRoute(forward, backward, target);
        for (int[] pair : res) {
            System.out.println(pair[0] + "," + pair[1]);
        }
    }
}
