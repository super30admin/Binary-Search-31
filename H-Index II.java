class Solution {
    public int hIndex(int[] citations) {

        int n = citations.length;
        int left = 0;
        int right = citations.length-1;

        while(left<=right)
        {
            int mid = left + (right-left)/2;

            if(citations[mid] == n-mid) return n-mid;

            else if(citations[mid] > n-mid) right = mid-1;

            else left = mid+1;
        }

        return n-left;
    }
}
