//Time Complexity - O(mlog(n) + nlog(m) + m + n) = O(nlogn).
//Space Complexity - O(1)
public class OptimalUtilization {

    private List<int[]> method(int[][] a, int[][] b, int target) {
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(a, (x, y) -> x[1] - y[1]);
        Arrays.sort(b, (x, y) -> x[1] - y[1]);

        List<int[]> result = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int right = b.length - 1;

        while (left < a.length && right >= 0) {
            int currentSum = a[left][1] + b[right][1];
            if (a[left][1] + b[right][1] > target) {
                right--;
            } else {
                if (currentSum >= maxSum) {
                    if (currentSum > maxSum) {
                        result = new ArrayList<>();
                    }
                    maxSum = currentSum;
                    result.add(new int[]{a[left][0], b[right][0]});
                    if (a[left + 1][1] + b[right][1] > target) {
                        right--;
                    } else {
                        left++;
                    }
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
