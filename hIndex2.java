//Time complexity O(logn)
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int hIndex(int[] citations) {
        
         if(citations.length == 0){
            
            return -1;
        }
      //  int[] temp = new int[citations.length];
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        
        while(left <= right){
            
            int mid = left + (right - left) / 2;
             if(citations[mid] == n - mid){
                 
                 return n - mid;
             }
            else if(citations[mid] < n - mid){
              //  System.out.println("hitting");
                left = mid + 1;
            }
             else {
                right = mid - 1;
            }
        }
        return n - left;
        
    }
}