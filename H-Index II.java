class Solution {
    public int hIndex(int[] citations) {

        // binary search
        int low = 0;
        int high = citations.length-1;

        while(low < high){
            int mid = low + (high-low)/2;
            int needed = citations.length-mid;
            if(citations[mid] < needed) {
                low = mid + 1;
            } else if(citations[mid] > needed){
                high = mid;
            } else return needed;
        }

        int needed = citations.length-high;
        return citations[high] >= needed ? needed : 0;
        
    }
}
