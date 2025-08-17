//Time Complexity O(Log K)
//Space Complexity O(1)
//LeetCode tested

public class HIndexII {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(citations[mid] < n-mid)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return n-l;
    }
}
