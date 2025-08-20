//Time Complexity: O(log n) (binary search over the sorted array).
//Space Complexity: O(1) (constant extra variables).

//With citations sorted ascending, for index mid, candidate h = n - mid is the number of papers with at least citations[mid].
//If citations[mid] == h, return h; if citations[mid] < h, move right (low = mid + 1), else move left (high = mid - 1).
//After the loop, the smallest index with citations[idx] ≥ n - idx is low; return n - low.

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int diff = n - mid;

            if(diff == citations[mid]) return diff;
            else if(diff > citations[mid]) low = mid + 1;
            else high = mid - 1;
        }

        return n - low;
    }
}
