// TC :O(logn);
// SC :O(1)
public class Solution {
   public int hIndex(int[] citations) {
       int left=0, n=citations.length;
       int right=citations.length-1;
       while(left<=right){
           int mid=left+(right-left)/2;
           if(citations[mid]==n-mid){
               return n-mid;
           }
           else if(citations[mid]<n-mid){
               left=mid+1;

           }
           else{
               right=mid-1;
           }

       }

       return n-left;

   }

} 