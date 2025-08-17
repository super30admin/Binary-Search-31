//Time complexity: O(logN) since we apply binary search, which reduces the search space by half at each iteration.**

//Space complexity : O(1), because no additional data structures were used.**
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int h = n-1;
        
        while(l <= h){
            int mid = l+(h-l)/2;
            if(citations[mid] == n - mid) return citations[mid];
            if(citations[mid] < n - mid) l = mid+1;
            else h = mid - 1;
        }
        return n-l;
    }
}

