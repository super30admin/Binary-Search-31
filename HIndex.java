// the time complexity of this implementation is O(n)
class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1]; // create buckets array to store counts of papers with specific citations

        // fill buckets array with counts of papers with specific citations
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }

        int count = 0; // count of papers with h or more citations
        for (int i = n; i >= 0; i--) {
            count += buckets[i]; // add count of papers with specific citations to count
            if (count >= i) { // check if count is greater than or equal to i, return i
                return i;
            }
        }

        return 0; // if no h-index is found, return 0
    }
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        HIndex solution = new HIndex();
        int hIndex = solution.hIndex(citations);
        System.out.println("The h-index is: " + hIndex); // The h-index is: 3
    }

}
