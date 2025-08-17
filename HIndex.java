/*
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * Did this code run successfully on LeetCode: yes
 * Approach: We are using BS to find out the element whose citations and difference is equal. 
 * We calculate the difference for each citation.
 */

public class HIndex {
    public static int hIndex(int[] citations) {
        if(citations.length == 0 || citations == null)
            return 0;
        int n = citations.length;
        int low = 0;
        int high = n - 1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            int diff = n - mid;
            if(citations[mid] == diff)
                return diff;
            else if(citations[mid] > diff)
            {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return n - low;
    }

    public static void main(String[] args) {
        int[] citations = {0,1,3,5,6};
        System.out.println(hIndex(citations));
    }
}
