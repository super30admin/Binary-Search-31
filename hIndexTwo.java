public class hIndexTwo {
    public int hIndex(int[] citations) {
        int low = 0, high = citations.length - 1;
        int n = citations.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int diff = n - mid;
            if (citations[mid] > diff) {
                low = mid + 1;
            } else if (citations[mid] < diff) {
                high = mid - 1;
            } else {
                return diff;
            }
        }
        return n - low;
    }

    public static void main(String[] args) {
        hIndexTwo hIndexCalculator = new hIndexTwo();
        int[] citations = { 0, 1, 3, 5, 6 };
        int hIndex = hIndexCalculator.hIndex(citations);
        System.out.println("The h-index is: " + hIndex);
    }
}
