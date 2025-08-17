//Problem 90 :  H-Index II
//TC: O(logN)
//SC: O(1)

/*
     1) Bruteforce- Linear Search :O(N)
        Just find the difference between the length of array and the current index.
        If citation value at that index become equal to the difference or greater than the difference, then just return the difference
     2) Binary Search : similar to floor
        find difference between n and the mid. If citation at mid == difference just return diff. Else if diff > citation at mid move start pointer which means valid difference will be at right side. Otherwise move the end pointer and note down the difference, because there could be 1 valid answer


*/

class Solution90 {
    public int hIndex(int[] citations) {
     
        //TC:O(log(N))
        //binary search similar to floor
        //find difference between n and the mid. If citation at mid == difference just return diff. Else if diff> citation at mid move start pointer which means valid difference will be at right side. Otherwise move the end pointer and note down the difference, because there could be 1 valid answer
        
        int start = 0;
        int end   = citations.length-1;
        int n     = citations.length;
        int res = -1;
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            int diff = n - mid;
            
            if(citations[mid] == diff){
                return diff;
            }
            
            if(diff>citations[mid]){
                start = mid+1;
            }else{
                res = diff;
                end = mid-1;
            }
            
        }
        
        return res==-1 ? 0:res;
        
        //Bruteforce
        /* Just find the difference between the length of array and the current index.
        If citation value at that index become equal to the difference or greater than the difference, then just return the difference
        TC:O(N)
        if(citations==null || citations.length==0) return 0;
        
        int n = citations.length;
        
        for(int i=0;i<n;i++){
            int diff = n-i;
            
            if(citations[i]>=diff){
                return diff;
            }
        }
        
        return 0;*/
    }
}