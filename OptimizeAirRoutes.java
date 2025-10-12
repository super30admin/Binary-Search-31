import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptimizeAirRoutes {

    public List<int[]> optimalRoutes(int[][] forward, int[][] back, int target) {
        Arrays.sort(forward, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(back, Comparator.comparingInt(a -> a[1]));

        final List<int[]> result = new ArrayList<>();
        int best = -1;

        for (int[] f : forward) {
            int remain = target - f[1];
            if (remain < 0) break; // forward distances only grow

            int j = upperBound(back, remain); // rightmost index with dist <= remain
            if (j < 0) continue;

            int sum = f[1] + back[j][1];
            if (sum < best) continue;

            // collect all back routes with the same distance as back[j][1]
            int k = j;
            while (k >= 0 && back[k][1] == back[j][1]) {
                if (sum > best) {
                    result.clear();
                    best = sum;
                }
                result.add(new int[]{ f[0], back[k][0] });
                k--;
            }
        }
        return result;
    }

    // returns index of the last element with value <= key; -1 if all > key
    private int upperBound(int[][] arr, int key) {
        int lo = 0, hi = arr.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid][1] <= key) { ans = mid; lo = mid + 1; }
            else { hi = mid - 1; }
        }
        return ans;
    }

    public static void main(String[] args) {
        final OptimizeAirRoutes optimizeAirRoutes = new OptimizeAirRoutes();
        final List<int[]> output1 = optimizeAirRoutes.optimalRoutes(
                new int[][] {{0, 1000}, {1, 2000}, {2, 3500}, {3, 5000}, {7, 4100}, {4, 6000}, {5, 6500}, {6, 7000}},
                new int[][] {{0, 1500}, {1, 2500}, {3, 3000}, {4, 4500}, {5, 6000}, {6, 8000}}, 6500
        );

        System.out.println(
                output1.stream()
                        .map(Arrays::toString)
                        .collect(java.util.stream.Collectors.joining(", ", "[", "]")) //[[1, 4], [2, 3], [3, 0]]
        );

        final List<int[]> output2 = optimizeAirRoutes.optimalRoutes(
                new int[][] {{0, 1000}, {1, 2000}, {2, 3500}, {3, 5000}, {7, 4100}, {4, 6000}, {5, 6500}, {6, 7000}},
                new int[][] {{0, 1500}, {1, 2500}, {3, 3000}, {4, 4500}, {5, 6000}, {6, 8000}}, 7200
        );

        System.out.println(
                output2.stream()
                        .map(Arrays::toString)
                        .collect(java.util.stream.Collectors.joining(", ", "[", "]")) //[[7, 3]]
        );
    }
}
