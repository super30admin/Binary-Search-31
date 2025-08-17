//Timecomplexity:- O(logn)
//spacecomplexity:-O(10;
//Did it run on leetcode:-yes;
//What problems did you face?:- got many testcases error.
//Yourcode with explanation:- Applied binary search and when citations[middle]==n-h returning middle element or else after
// while loop returing n-low;
class Solution {
    public int hIndex(int[] citations) {
        int low=0;
        int high=citations.length-1;
        while(low<=high){
            int middle=low+(high-low)/2;
            if(citations[middle]==citations.length-middle){
                return citations[middle];
            }
            else if(citations[middle]<citations.length-middle){
                low=middle+1;
            }
            else{
                high=middle-1;
            }
        }
        return citations.length-low;
    }
        
}