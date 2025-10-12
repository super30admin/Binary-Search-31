//TC: O(logn), SC: O(1)
//Approach: We need to find the first index where the difference n - h <= citations[i], that will be our h index
//and h index has to satisfy 2 conditions, h no of papers have >= h citations and n - h papers have <= h citations
public class HIndex2 {

    public int hIndex(int[] citations) {
        int low = 0, high = citations.length - 1, n = citations.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (n - mid == citations[mid]) return n - mid;
            else if (n - mid > citations[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return n - low;
    }
}
