public class HIndex {

/*
TC :O(n)
SC :O(1)
LC : yes
Problems : No
 */

    /**
     * Basically, we want to find the index where citations[i] crosses the n-i value.
     * We perform a linear search and return the i
     */
    public int hIndex_linearSearch(int[] citations) {
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int diff = n - i;
            if (citations[i] >= diff)
                return diff;

        }
        return 0;
    }

    /**
     * Basically, we want to find the index where citations[i] crosses the n-i value.
     * We perform a binary search and return the i
     *
     * @param citations
     * @return
     */
    public int hIndex_binarySearch(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (n - mid == citations[mid])
                return n - mid;
            else if (n - mid > citations[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return n - low;
    }
}
