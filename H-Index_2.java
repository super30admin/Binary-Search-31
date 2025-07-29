class Solution {
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int diff = citations.length - mid;
            if(diff == citations[mid]){
                return diff;
            }else if(diff > citations[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return citations.length - low;
    }
}
