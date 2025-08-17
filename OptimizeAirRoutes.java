import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OptimizeAirRoutes {
    public List<int[]> primeAirTime(int[][] arr1, int[][] arr2, int target) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(arr1, (a, b) -> a[1] - b[1]);
        Arrays.sort(arr2, (a, b) -> a[1] - b[1]);
        int maxSum = Integer.MIN_VALUE;
        int i = 0, j = arr2.length - 1;
        while (i < arr1.length && j >= 0) {
            int sum = arr1[i][1] + arr2[j][1];
            if (sum <= target) {
                if (sum > maxSum) {
                    maxSum = sum;
                    result.clear();
                    result.add(new int[] { arr1[i][0], arr2[j][0] });
                } else if (sum == maxSum) {
                    result.add(new int[] { arr1[i][0], arr2[j][0] });
                }
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OptimizeAirRoutes obj = new OptimizeAirRoutes();
        int[][] arr1 = { { 1, 500 }, { 2, 1000 }, { 3, 2500 }, { 4, 3000 }, { 5, 3500 }, { 6, 4500 } };
        int[][] arr2 = { { 1, 1000 }, { 2, 1500 }, { 3, 2500 }, { 4, 4500 }, { 5, 6000 } };
        int target = 7000;
        List<int[]> optimalRoutes = obj.primeAirTime(arr1, arr2, target);

        System.out.println("Optimal Routes:");
        for (int[] route : optimalRoutes) {
            System.out.println(Arrays.toString(route));
        }
    }
}
