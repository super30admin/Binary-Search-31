// H Index
// Time - O(lg N)
// Space - O(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int high = n - 1;
        int low = 0;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(citations[mid] == n - mid) {
                return n - mid;
            }
            else if(citations[mid] > n - mid) {
                high = mid - 1;
            }
            else if(citations[mid] < n - mid){
                low = mid + 1;
            }
        }        
        
        return n - low;
    }
} 

// Brute Force 
// Time - O(N)
// Space - O(1)

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        
        int n = citations.length;
        for(int i=0;i<n;i++) {
            int diff = n - i;
            if(citations[i]>=diff) {
                  return diff;
            }
        }
        
        return 0;
    }
}
