
// TC : O(mlogm + nlogm)
// SC : O(1)

package S30_Codes.Binary_Search_3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimizationOfRoutes {
    public static List<Integer[]> primeAirTime(int[][] arr1, int[][] arr2, int k) {
        List<Integer[]> lst = new ArrayList<>();
        if(arr1.length == 0 || arr2.length == 0)
            return lst;

        Arrays.sort(arr2, (a, b) -> a[1] - b[1]);
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr1.length; i++){
            int val1 = arr1[i][1];
            int remVal = k - val1;
            int closetElementIdx = findEleOrSmallerEle(arr2, remVal);

            if(closetElementIdx > -1){
                int val2 = arr2[closetElementIdx][1];
                int val2StartIdx = findEleFirstIdx(arr2, val2);
                int val2EndIdx = findEleLastIdx(arr2, val2);

                int curSum = val1 + val2;

                if(curSum >= max){
                    if(curSum > max)
                        lst = new ArrayList<>();

                    Integer[] arr = new Integer[3];
                    arr[0] = i;
                    arr[1] = val2StartIdx;
                    arr[2] = val2EndIdx;
                    lst.add(arr);
                    max = curSum;
                }
            }
        }

        List<Integer[]> res = new ArrayList<>();
        for(Integer[] curList : lst){
            int start = curList[1];
            int end = curList[2];

            while(start<=end){
                Integer[] arr = new Integer[2];
                arr[0] = arr1[curList[0]][0];
                arr[1] = arr2[start][0];
                res.add(arr);
                start++;
            }
        }

        return res;
    }

    private static int findEleFirstIdx(int[][] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid][1] < target)
                start = mid+1;
            else
                end = mid - 1;
        }
        return start;
    }

    private static int findEleLastIdx(int[][] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid][1] <= target)
                start = mid+1;
            else
                end = mid - 1;
        }
        return end;
    }


    private static int findEleOrSmallerEle(int[][] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid][1] == target)
                return mid;
            if(arr[mid][1] < target)
                start = mid+1;
            else
                end = mid - 1;
        }
        return end;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
        int[][] arr2 = {{1, 2}, {2, 3}, {3, 3}, {4, 3}, {5, 5}, {6, 3}, {7, 5}};
        int k = 11;

        List<Integer[]> res = primeAirTime(arr1, arr2, k);
        for(Integer[] curRes : res){
            System.out.println(curRes[0] + ", " + curRes[1]);
        }
    }

}