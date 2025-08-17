// TC : O(log n)
// SC : O(1)

package S30_Codes.Binary_Search_3_1;

class H_Index_II {
    public int hIndex(int[] citations) {
        int start =0;
        int n = citations.length;
        int end = n-1;

        while(start <= end){
            int mid = (end-start)/2 + start;
            int rCount = n-mid;

            if(citations[mid] == rCount){
                return citations[mid];
            }

            if(citations[mid] < rCount){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }

        return n-start;
    }
}