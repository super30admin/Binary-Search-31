/*
method1 -
is to linearly scan the array to find the position where from further on elements will have atleast h citations and below it have no more than h

time complexity :O(n)

method 2 - Binary Search
we find the difference element which is equal to n - mid.
if element is >, move high = mid-1, else low = mid+1

finally if we dont find while loop, we return n-low as 

time complexity: O(log n)

*/
class Solution {
    public int hIndex(int[] citations) {
        
        if(citations.length == 0)return 0;
        
        int n = citations.length;
            //method1
//         for(int i = 0;i < citations.length;i++){
//             int diff = n -i;
//             if(citations[i] >= diff){
//                 return diff;
//             }
//         }
        
        //method2
        int low = 0;
        int high = n-1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(citations[mid] == n - mid){
                return n-mid;
            }else if(citations[mid] > n-mid){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return n-low;
    }
}