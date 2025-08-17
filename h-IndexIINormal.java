// Time complexity = O(n)
// space complexity = O(1).

class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length;
        for(int i=0;i< citations.length;i++) {
            if(citations[i] >= length - i) {
                return length-i;
            }
        }
        return 0;
    }
}