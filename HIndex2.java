class Solution {
    public int hIndex(int[] citations) {
        
        //binary search

        //so the idea that given an element at index i, check if it is greater than or equal to (>=) n - i, where n is the total number of elements
        //if this condition is true, we move towards left to find a more higher value of h index
        //as we keep moving toward the left half of the array, the value of n - i (h) keeps increasing
        //if the above check is failed then we move toward the right side to find the smaller value of n - i (h).
        //finally while loop exits, n - low is returned. 

        if(citations == null || citations.length == 0){
            return 0;
        }

        int n = citations.length;
        int low = 0;
        int high = n - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(citations[mid] >= n - mid){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return n - low;

    }
}