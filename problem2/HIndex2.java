// Time Complexity : O(log n), n -> Number of papers
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class HIndex2 {
	/********************* LINEAR SEARCH *********************/
	// Time Complexity : O(n), n -> Number of papers
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int hIndexLinear(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}

		int n = citations.length;
		for (int i = 0; i < n; i++) {
			if ((n - i) <= citations[i]) {
				return n - i;
			}
		}

		return 0;
	}

	/********************* BINARY SEARCH *********************/
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}

		int n = citations.length;
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (citations[mid] == n - mid) {
				return n - mid;
			} else if (citations[mid] < n - mid) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return n - low;
	}

	public static void main(String[] args) {
		HIndex2 obj = new HIndex2();
		int[] citations = { 0, 1, 3, 5, 6 };
		System.out.println("H-Index: " + obj.hIndex(citations));
	}

}
