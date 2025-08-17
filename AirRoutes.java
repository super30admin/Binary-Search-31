// TC : O(mlogm+nlogm);
//SC : O(k);
class Solution {

    public List<int[]> optimalAirRoute(int[][] forward, int[][] backward, int target) {
        List<int[]> output = new ArrayList<>();

        if (forward.length == 0 || backward.length == 0 || target == 0) {
            return output;
        }

        int max = 0;
        Arrays.sort(backward, (a, b) -> (a[1] - b[1]));

        for (int i = 0; i < forward.length; i++) {
            int index = binarySearch(backward, target - forward[i][1]);
            if (index != -1) {
                int sum = forward[i][1] + backward[index][1];
                if (sum >= max) {
                    if (sum > max) {
                        output = new ArrayList<>();
                    }
                    max = sum;
                    output.add(new int[]{forward[i][0], backward[index][0]});
                }
            }
        }

        return output;
    }

    public int binarySearch(int[][] backward, int target) {
        int left = 0;
        int right = backward.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (backward[mid][1] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }