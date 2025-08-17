// approch 1
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    // approch 1 linear search
    public static int hIndex1(int[] citations) {
        int n = citations.length;
        // loop through all the citations
        for (int i = 0; i < n; i++) {
            // diffrence of number of citations greater then at particular index
            int diff = n - i;
            // if diffrence is less than the number of citatation at particular index we
            // return diffrence
            if (diff <= citations[i]) {
                return diff;
            }
        }
        return 0;
    }

    // approch 2 binary search
    public static int hIndex2(int[] citations) {
        int n = citations.length;
        // loop through all the citations
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            // mid element
            int mid = l + (r - l) / 2;
            // diffrence of number of citations greater then at mid index
            int diff = n - mid;
            // if diff is equal to the number of citatation at particular index we
            // return diffrence
            if (diff == citations[mid]) {
                return diff;
            } else if (diff > citations[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // if w didn't find an exact match
        return n - l;
    }

    public static void main(String[] args) {
        int[] citations = new int[] { 0, 1, 3, 5, 6 };
        System.out.println(hIndex1(citations));
        System.out.println(hIndex2(citations));
    }
}