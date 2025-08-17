import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// TC: O(m + n + m log n + n log m): For sorting both the list first and then traversing all the int[] in the lists
// SC: O(1) no space is used.

// l is set to 0 and h is set to n-1. Sum is compared with the target and max sum is updated.
// In b list, while traversing adjacent numbers are checked for equal max sum, if equal, 
// then the number is added in the list
public class RouteOptimization {

    public static void main(String[] args) {
        // a = [[1, 3], [2, 5], [3, 7], [4, 10]]
        // b = [[1, 2], [2, 3], [3, 4], [4, 5]]
        List<int[]> a = new ArrayList<>();
        a.add(new int[] { 1, 3 });
        a.add(new int[] { 2, 5 });
        a.add(new int[] { 3, 7 });
        a.add(new int[] { 4, 10 });
        List<int[]> b = new ArrayList<>();
        b.add(new int[] { 1, 2 });
        b.add(new int[] { 2, 3 });
        b.add(new int[] { 3, 4 });
        b.add(new int[] { 4, 5 });
        for (int[] i : getOptimized(a, b, 10)) {
            System.out.print(Arrays.toString(i) + ",");
        }
    }

    private static List<int[]> getOptimized(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, (i, j) -> i[1] - j[1]);
        Collections.sort(b, (i, j) -> i[1] - j[1]);
        int m = a.size();
        int n = b.size();
        int l = 0;
        int h = n - 1;
        int max = Integer.MIN_VALUE;
        List<int[]> list = new ArrayList<>();
        while (l < m && h >= 0) {
            int sum = a.get(l)[1] + b.get(h)[1];
            if (sum > target)
                h--;
            else {
                if (max <= sum) {
                    if (max < sum) {
                        max = sum;
                        list.clear();
                    }
                    list.add(new int[] { a.get(l)[0], b.get(h)[0] });
                    int index = h - 1;
                    while (index >= 0 && b.get(index)[1] == b.get(index + 1)[1])
                        list.add(new int[] { a.get(l)[0], b.get(index--)[0] });
                }
                l++;
            }
        }
        return list;
    }

}