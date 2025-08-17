//Time: O(n)
//Space: O(1)
// class Solution {
//     public int hIndex(int[] citations) {
//         if(citations == null || citations.length == 0)
//             return 0;
//         for(int i = 0; i < citations.length; i++){
//             if(citations[i] >= citations.length - i)
//                 return citations.length - i;
//         }
//         return 0;
//     }
// }
//Time: O(logn)
//Space: O(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(citations[mid] == n - mid)
                return citations[mid];
            if(citations[mid] < n - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return n - left;
        
    }
}
