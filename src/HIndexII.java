//Time Complexity : O(logN)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply Binary Search. At every mid, check if it is satisfying the condition
 * that mid element == # of elements to it. If so, return it, else if # of
 * elements are less than mid element, then move left to mid + 1, else right to
 * mid - 1. If no exact match is found, return length of array - left.
 *
 */
class Solution {
	public int hIndex(int[] citations) {
		int n = citations.length;
		int l = 0, r = n - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (citations[mid] == n - mid) {
				return citations[mid];
			} else if (citations[mid] < n - mid)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return n - l;
	}
}

// [0,1,3,5,6]