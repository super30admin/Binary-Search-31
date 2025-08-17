// Time Complexity O(n)
// Space Complexity O(1)
// Runs on LeetCode YES
class Solution {
    public int hIndex(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }
}