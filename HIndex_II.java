// Time Complexity : O(logn)
// Space Complexity : O(1)
// Method used : Binary Search

class Solution {
    public int hIndex(int[] citations) {

        // In H index problem we had to sort the array but here the array is already given in sorted order so just traverse the 
        // array. This would be brute force

        // If the array is already sorted we can also apply binary search to do so

        int n = citations.length;

        int low = 0, high = n - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(citations[mid] == n - mid) return n - mid;

            // In brute force approach if citations[i] < n - i we just kept moving forward, we do the same thing here

            else if(citations[mid] < n - mid) low = mid + 1;

            else high = mid - 1;
        }

        return n - low;
    }
}