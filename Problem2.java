// 275. H-Index II// https://leetcode.com/problems/h-index-ii/


public class Problem2 {
    public static void main(String[] args) {
            Problem2 problem = new Problem2();
            int[] citations = {0, 1, 3, 5, 6};
            System.out.println("H-Index: " + problem.hIndexBinarySearch(citations)); // Output: 3
            citations = new int[]{1, 2, 100};
            System.out.println("H-Index: " + problem.hIndexBinarySearch(citations)); // Output: 2
            citations = new int[]{0, 0, 0, 0, 0};
            System.out.println("H-Index: " + problem.hIndexBinarySearch(citations)); // Output: 0
            citations = new int[]{1, 2, 3, 4, 5};
            System.out.println("H-Index: " + problem.hIndexBinarySearch(citations)); // Output: 3
            citations = new int[]{5, 6, 7, 8, 9};
            System.out.println("H-Index: " + problem.hIndexBinarySearch(citations)); // Output: 5

            // without binary search
             citations = new int[]{0, 1, 3, 5, 6};
            System.out.println("H-Index: " + problem.hIndex(citations)); // Output: 3
            citations = new int[]{1, 2, 100};
            System.out.println("H-Index: " + problem.hIndex(citations)); // Output: 2
            citations = new int[]{0, 0, 0, 0, 0};
            System.out.println("H-Index: " + problem.hIndex(citations)); // Output: 0
            citations = new int[]{1, 2, 3, 4, 5};
            System.out.println("H-Index: " + problem.hIndex(citations)); // Output: 3
            citations = new int[]{5, 6, 7, 8, 9};
            System.out.println("H-Index: " + problem.hIndex(citations)); // Output: 5
    }

     public int hIndex(int[] citations) {
        if(citations == null || citations.length==0){
            return 0;
        }
        int n = citations.length;
        for(int i=0;i<n;i++){
            if(citations[i]>= n-i){
                return n-i;
            }
        }
        return 0;

    }

     public int hIndexBinarySearch(int[] citations) {
        if(citations == null || citations.length==0){
            return 0;
        }
        int n = citations.length;
        //binary search
        int low =0;
        int high = n-1;
        while (low<=high){
            int mid = low+(high-low)/2; //prevent int overflow
            if(citations[mid]>= n - mid){
                high =mid-1;
            }else
            {
                low = mid+1;
            }
        }
        return n-low;

    }
}
