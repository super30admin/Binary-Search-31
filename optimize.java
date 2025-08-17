Time Complexity = o(log(m) + n)
Space Complexity = o(1)
// import 
import java.util.*;
import java.util.Arrays;

public class optimize{

    static List<List<Integer>> result = new ArrayList<>();
    static int max = 0;
    public static void optimize(int[][] fwd, int[][] bwd, int target)
    {
        if (bwd.length > fwd.length)
            optimize(bwd, fwd, target);

        for(int[] arr: bwd)
        {
            if(target - arr[1] >= 0)
                binarySearch(fwd, arr, target-arr[1]);
        }
    }
    private static void binarySearch(int[][] l1, int[] l2, int tar)
    {
        int low = 0;
        int high = l1.length-1;
        while(low < high)
        {
            int mid = low + (high - low) /2;
            if(l1[mid][1] == tar)
            {
                int[] val = {l2[0], l1[mid][0]};
                result.add(Arrays.asList(val));
            }
            else if(l1[mid][1] > tar)
            {
                high = mid - 1;
            }
            else
            {

                if (l1[mid][1] + l2[1] == max) {
                    int[] val = {l2[0], l1[mid][0]};
                    result.add(Arrays.asList(val));
                    max = l1[mid][1] + l2[1];
                }
                else if(l1[mid][1] + l2[1] > max)
                {
                    if(!result.isEmpty())
                       result.remove(result.size()-1);
                    int[] val = {l2[0], l1[mid][0]};
                    result.add(Arrays.asList(val));
                    max = l1[mid][1] + l2[1];
                }
                low  = mid +1;
            }
                

        }

    }

    public static void main(String[] args)
    {
        int[][] fwd = {{1,2000}, {2,4000}, {3,6000}};
        int[][] bwd = {{1, 2000}};
        int target  = 7000;
        optimize(fwd, bwd, target);
        System.out.println(result);
    }
}