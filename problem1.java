import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Approach 1
// Time complexity: O(n*m)
public class problem1 {
    public static List<int[]> findOptimalPairs(int[][] arr1, int[][] arr2, int target) {
        List<int[]> res= new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;

        for (int[] a:arr1)
        {
            for (int[] b: arr2)
            {
                int sum= a[1]+b[1];

                if (sum<=target)
                {
                    // found a better max sum, clear prev elements
                    if (sum>maxSum)
                    {
                        res.clear();
                        maxSum= sum;
                        res.add(new int[]{a[0],b[0]});

                    }
                }
                else if (sum==target){
                    res.add(new int[]{a[0], b[0]});
                }
            }
        }
        return res;
    }

    //Approach 2: 2 pointers
    // Time complexity: O(nlogn+mlogm)
    public static List<int[]> findOptimalPairs1(int[][] arr1, int[][] arr2, int target) {
        List<int[]> res = new ArrayList<>();
        int maxSum= Integer.MIN_VALUE;

        Arrays.sort(arr1, (a,b) -> Integer.compare(a[1], b[1])); // asc order
        Arrays.sort(arr2, (a,b) -> Integer.compare(b[1],a[1])); // desc order

        int i=0,j=0;
        while (i< arr1.length && j<arr2.length)
        {
            int sum= arr1[i][1]+ arr2[j][1];
            if (sum> target){j++;}
            else {
                if (sum> maxSum)
                {
                    maxSum= sum;
                    res.clear();
                    res.add(new int[]{arr1[i][0], arr2[j][0]});
                } else if (sum== maxSum) {
                    res.add(new int[]{arr1[i][0], arr2[j][0]});
                }
                int k=j+1;
                while (k<arr2.length && arr2[k][1]==arr2[j][1])
                {
                    if (sum> maxSum){
                        res.clear();
                        maxSum=sum;
                        res.add(new int[]{arr1[i][0], arr2[k][0]});
                    } else if (sum==maxSum) {
                        res.add(new int[]{arr1[i][0], arr2[k][0]});
                    }
                    k++;
                }
                i++;
            }
        }
        return res;
    }
}
