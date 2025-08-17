//Time Complexity - O(nlog(n)).
// Space Complexity - O(1).
class HIndex2 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return -1;
        }

        int n = citations.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (citations[mid] >= n - mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return n - low;
    }
}
