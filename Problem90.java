//Time Complexity: O(log N)
//Space Complexity: O(1)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lo = 0, hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (citations[mid] >= n - mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return n - lo;
    }
}