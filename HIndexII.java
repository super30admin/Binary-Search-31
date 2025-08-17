class HIndexII {
    
    // Time Complexity: O(log n)    (where n -> no. of elements in the array)
    // Space Complexity: O(1)
    
    public int hIndex(int[] citations) {
        // Edge Case Checking
        if(citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        int low = 0;
        int high = citations.length-1;
        
        // Binary Search
        while(low <= high){
            int mid = low + (high - low)/2;
            if(citations[mid] == (n-mid))
                return citations[mid];
            else if(citations[mid] > (n-mid))
                high = mid - 1;
            else
                low = mid + 1;
        }

        return n - low;
    }
}