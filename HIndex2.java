//Linear search approach
class Solution {

    //Time Complexity: 0(n) where n is the no of citations
    //Space Complexity : 0(1)
    //Did it successfully run on leecode: Yes
    //DId you face any error while coding: No

    //In short explain your approach

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int m = citations.length;   //calculating the length of the citations array
        for(int i = 0; i < m; i++){ //running a loop
            int difference = m - i;     //calculating the citations each paper got
            if(citations[i] >= difference){ //returning citation if the paper for that citation is greater than or equal to the no. of citations
                return difference;
            }
        }
        return 0;
    }
}

//Binary Search approach

class Solution {

    //Time Complexity: 0(log n) where n is the no of citations
    //Space Complexity : 0(1)
    //Did it successfully run on leecode: Yes
    //DId you face any error while coding: No

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int n = citations.length;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            int diff = n - mid;
            if(n - mid == citations[mid]){
                return n - mid;
            }
            else if(citations[mid] < n-mid){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return n - low;
    }
}

