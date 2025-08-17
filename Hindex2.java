//Time complexity : O(logn)
//Space complexity : O(1)

class Solution {

    //code 2 : binary search, at mid we see if here citations = papers that have those many citations or more. these pointers are counted at every index

    public int hIndex(int[] citations) {

        int n = citations.length;
        int low=0, high=n-1;

        while(low <= high)
        {
            int mid = low + (high - low)/2;

            //if papers = citations at this point
            if(citations[mid] == n - mid)
                return n-mid;
            else if(citations[mid] > n-mid)
                high = mid -1;
            else
                low = mid+1;
        }

        //if high and low pointers have crossed, low pointer gives the answer
        return n - low;
    }
}
