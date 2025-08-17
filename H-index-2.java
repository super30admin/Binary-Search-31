class Solution {
    public int hIndex(int[] citations) {
        
        // Empty check
        if (citations == null || citations.length == 0){
            return 0;
        }
        
        int n = citations.length;
        
        int low = 0;
        int high = n  - 1;
        
        
        // Binary search 
        // Find where the citations[i] > diff started
        
        while (low <= high){
            
            int mid =  low + (high - low)/2;
            
            int diff = n - mid; // papers that are greater than mid
            
            if (citations[mid] == diff){
                // update the diff
                return diff;
            }
            
            else if (citations[mid] > diff){
                // Move left
                high = mid - 1;
            }
            
            else {
                low =  mid + 1;
            }
        }
        
        
        return n - low; // h-index at low
        
    }
}