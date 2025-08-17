//Time complexity-O(logn)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
//the length of citations is the max h index so we compare each value with n-index 
class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(n-mid>citations[mid])
                low=mid+1;
            else if(n-mid<citations[mid])
                high=mid-1;
            else
                return(n-mid);
        }
        return (n-low);
    }
}