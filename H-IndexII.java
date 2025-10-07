/* Approach1:
* H index - max value of h such that each researchers has published at least h papers that have each been cited at least h times
* chose h such a way, 
    - h number of papers >= (at least) h number of citations 
    - and total citations n - h(n - h papaers should have less than h citations) <= h citations
* if we observe closely then the above two conditions are complement of each other and hence we can just check the second condition and if that holds true. 
* TC: O(n) -> iterate over the entire citations array
* SC: O(1) -> constant, no additional space is used
*/
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        for(int i = 0; i < n; i++){
            int diff = n - i;
            if(diff <= citations[i])
                return diff;
        }
    return 0;
    }
}

/*
* Approach2: as the array is sorted, we can do a binary search
    - find mid, if diff == citations[mid] -> go home -> return diff
    - if diff > citations[mid] -> low = mid + 1 
    - else high = mid - 1;
    - at the end wherever the low is, the diff at that low index should be the h index
* TC: O(logn) -> iterate over the entire citations array
* SC: O(1) -> constant, no additional space is used
*/
class Solution {
    public int hIndex(int[] citations) {
        int low = 0;
        int n = citations.length;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int diff = n - mid;
            if(diff == citations[mid])
                return diff;
            else if(diff > citations[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
    return n - low;
    }
}