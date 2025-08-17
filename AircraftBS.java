import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Time Complexity : O(MN)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * This is like two pointer approach and two sum problem. Sort the arrays in
 * ascending order and then start iterating 1st array from 0th index and 2nd
 * array from last. start adding those two and see if they match the target. If
 * so, add them to the results and skip the duplicates from the 2nd array. If no
 * combination is found, return empty list.
 *
 */
public class AirCraftBS {
	private List<int[]> getPairs(List<int[]> arr1, List<int[]> arr2, int target) {
		Collections.sort(arr1, (i, j) -> i[1] - j[1]);
		Collections.sort(arr2, (i, j) -> i[1] - j[1]);
		List<int[]> ans = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		int m = arr1.size();
		int n = arr2.size();
		int i = 0;
		int j = n - 1;
		while (i < m && j >= 0) {
			int sum = arr1.get(i)[1] + arr2.get(j)[1];
			if (sum > target) {
				j--;
			} else {
				if (max <= sum) {
					if (max < sum) {
						max = sum;
						ans.clear();
					}
					ans.add(new int[] { arr1.get(i)[0], arr2.get(j)[0] });
					int index = j - 1;
					while (index >= 0 && arr2.get(index)[1] == arr2.get(index + 1)[1]) {
						ans.add(new int[] { arr1.get(i)[0], arr2.get(index--)[0] });
					}
				}
				i++;
			}
		}

		if (ans.size() == 0) {
			ans.add(new int[] {});
		}
		return ans;
	}
}
