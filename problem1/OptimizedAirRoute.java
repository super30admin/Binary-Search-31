// Time Complexity : O(mlog m + nlog n+ mlog n), m -> Length of forward routes, n -> Length of return routes 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimizedAirRoute {
	/*********************************************************************************
	 ********************************** BINARY SEARCH ********************************
	 *********************************************************************************/
	public List<List<Integer>> optimalRoute(int maxTravelDist, int[][] forwardRoutes, int[][] returnRoutes) {
		List<List<Integer>> result = new ArrayList<>();

		if (forwardRoutes == null || forwardRoutes.length == 0 || returnRoutes == null || returnRoutes.length == 0) {
			return result;
		}

		Arrays.sort(forwardRoutes, (a, b) -> a[1] - b[1]);
		Arrays.sort(returnRoutes, (a, b) -> a[1] - b[1]);

		int maxDistance = 0;

		for (int i = 0; i < forwardRoutes.length; i++) {
			int rDistance = maxTravelDist - forwardRoutes[i][1];
			int index = binarySearch(returnRoutes, rDistance);
			if (index == -1) {
				continue;
			}

			int total = forwardRoutes[i][1] + returnRoutes[index][1];
			if (total > maxDistance) {
				maxDistance = total;
				result = new ArrayList<>();
				result.add(new ArrayList<>(Arrays.asList(forwardRoutes[i][0], returnRoutes[index][0])));
			} else if (total == maxDistance) {
				List<Integer> route = new ArrayList<>();
				route.add(forwardRoutes[i][0]);
				route.add(returnRoutes[index][0]);
				result.add(route);
			}
		}

		return result;
	}

	private int binarySearch(int[][] routes, int target) {
		int low = 0;
		int high = routes.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (routes[mid][1] == target) {
				return mid;
			} else if (routes[mid][1] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return high;
	}

	public void print(List<List<Integer>> routes) {
		for (List<Integer> route : routes) {
			for (Integer id : route) {
				System.out.print(id + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		OptimizedAirRoute obj = new OptimizedAirRoute();
		int[][] forwardRoutes = { { 1, 1000 }, { 2, 2000 }, { 3, 3000 }, { 4, 4500 }, { 5, 6000 } };
		int[][] returnRoutes = { { 1, 2000 }, { 2, 3500 }, { 3, 4500 }, { 4, 6500 } };
		int maxDistance = 7000;

		List<List<Integer>> optimalRoutePair = obj.optimalRoute(maxDistance, forwardRoutes, returnRoutes);
		System.out.println("Optimal routes: ");
		obj.print(optimalRoutePair);
	}

}
