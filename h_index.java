//TC=O(log(n))
//SC=O(1)
//Approach :here we solved using BINARY SEARCH method where 
//compare the citation of mid >=n-mid then move to left and reduce high to mid-1
//else go to right and increase low to mid+1

class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0){
            return 0;
        }
        int n=citations.length;
        /*for(int i=0;i<n;i++){
            if(citations[i]>=n-i){
                return n-i;
            }
        }
        return 0;*/

        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(citations[mid]>=n-mid){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            
        }
      return n-low;  
    }
}