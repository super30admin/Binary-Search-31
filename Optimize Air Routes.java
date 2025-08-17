// Time Complexity = O(mlog(n)) 

public class ClosestSum {
    public static void main(String[] args) {
        ClosestSum closestSum = new ClosestSum();
        int[] res = closestSum.find(new int[][]{
                {1, 3000},
                {2, 5000},
                {3, 4000},
                {4, 10000},
        }, new int[][]{
                {1, 2000},
                {2, 3000},
                {3, 4000},
        }, 11000);
        System.out.println(Arrays.toString(res));
    }

    int[] find(int[][] arr1, int[][] arr2, int target) {
        Arrays.sort(arr1, Comparator.comparingInt(l -> l[1]));

        int max = -1;
        int[] maxPair = new int[]{-1, -1};
        for (int i = 0; i < arr2.length; i++) {
            int low = 0, high = arr1.length;
            int diff = target - arr1[i][1];
            while (low != high) {
                int mid = low + (high - low) / 2;
                if (arr1[mid][1] <= diff) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int newVal = arr1[i][1] + arr2[low - 1][1];
            if (newVal > max) {
                maxPair = new int[]{arr1[i][0], arr2[low - 1][0]};
            }
        }

        return maxPair;
    }
}