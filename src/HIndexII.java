/**
 * @author Aditya Sinha
 * 
 * use binary search to find the smallest index where citations[mid] is ≥ n - mid
 * Time Complexity - O(log n)
 * Space Complexity - O(1)
 */
public class HIndexII {

	public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = n - mid;  // number of papers from mid to end
            
            if (citations[mid] == h) {
                return h; // exact match
            } else if (citations[mid] < h) {
                left = mid + 1; // need more citations, move right
            } else {
                right = mid - 1; // citations too high, move left
            }
        }
        
        return n - left; // final h-index
    }
}
