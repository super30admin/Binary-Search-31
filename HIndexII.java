// Time: O(Log N) | Space: O(1)

class Solution {
    public int hIndex(int[] citations) {
        int totalCitations = citations.length;
        int low = 0;
        int high = totalCitations-1;
        while(low <=high) {
            int mid = low+(high-low)/2;
            // diff is the h index
            int diff = totalCitations-mid;
            if(citations[mid] == diff) return diff;
            else if(citations[mid] > diff){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return totalCitations-low;
    }
}