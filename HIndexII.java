//Leetcode - 275
//Time Complexity - log(N)
//Space Complexity - O(1)
public class HIndexII {

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int low =0; int high =n-1;
        while(low <= high) {
            int mid = low+(high-low)/2;
            int diff = n - mid;
            if(citations[mid] == diff) {
                return diff;
            } else if(citations[mid] < diff) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return n - low;
    }

    //O(N)
   /* public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        for(int i=0; i<n;i++) {
            int diff = n-i;
            if(citations[i] >= diff) {
                return diff;
            }
        }
        return 0;
    }*/



}
