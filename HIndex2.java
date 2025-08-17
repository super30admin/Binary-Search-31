////TimeComplexity: O(log N)
////Space Complexity:O(1)
//class Solution {
//    public int hIndex(int[] citations) {
//        if(citations == null || citations.length ==0 ){
//            return 0;
//        }
//        int n = citations.length;
//        int low = 0;
//        int high = citations.length-1;
//        while(low<=high){
//            int mid = low + (high-low)/2;
//
//            if(citations[mid] == (n-mid)){
//                return citations[mid];
//            }
//
//            if(citations[mid] > n-mid){
//                high = mid - 1;
//            }else{
//                low = mid + 1;
//            }
//        }
//        return n - low;
//    }
//}
//
////TimeComplexity: O(N)
////Space Complexity:O(1)
//class Solution {
//    public int hIndex(int[] citations) {
//        if (citations == null || citations.length == 0) {
//            return 0;
//        }
//
//        int n = citations.length;
//        for (int i = 0; i < n; i++) {
//            if ((n - i) <= citations[i]) {
//                return n - i;
//            }
//        }
//
//        return 0;
//    }
//}