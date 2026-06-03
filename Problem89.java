//Time Complexity: O(m log m + n log m) where n = forward.length and m = backward.length
//Space Complexity: O(1)

class Solution {
    public List<int[]> optimalAirRoute(int[][] forward, int[][] backward, int target) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(backward, (a, b) -> a[1] - b[1]);
        int max = 0;

        for (int[] f : forward) {
            int index = binarySearch(backward, target - f[1]);
            if (index != -1) {
                int sum = f[1] + backward[index][1];
                if (sum >= max) {
                    if (sum > max) {
                        result = new ArrayList<>();
                    }
                    max = sum;
                    result.add(new int[]{f[0], backward[index][0]});
                }
            }
        }
        return result;
    }

    private int binarySearch(int[][] backward, int target) {
        int low = 0, high = backward.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (backward[mid][1] == target) {
                return mid;
            } else if (backward[mid][1] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
