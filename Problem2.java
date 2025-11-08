class Solution {
    public int hIndex(int[] citations) {

        if (citations.length == 1 && citations[0] > 0) return 1;

        int n = citations.length;
        

        int low = 0, high = n-1; 
        int hIndex = 0;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (citations[mid] >= n-mid) {
                hIndex = Integer.max(hIndex, n-mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return hIndex;
    }
}
