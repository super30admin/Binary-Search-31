Time Complexity: o(log(n))
Space Complexity: o(1)
class Solution {
    public int hIndex(int[] citations) {
        int papers = citations.length;
        int low = 0; int high = papers-1;
        int mid =0;
        while (low <= high )
        {
            mid = low + (high - low)/2;
            if(papers-mid == citations[mid])
            {
                return papers - mid;
            }
            else if(citations[mid] > papers-mid )
            {
                high = mid -1;
            }
            else 
                low = mid +1;
        }
        return papers-low;
    }
}