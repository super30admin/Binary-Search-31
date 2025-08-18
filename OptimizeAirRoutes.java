// Time Complexity : O(nlogn + mlogm +nlogm)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : Sort arrays based on values. For each index in arr1, check if target -arr1[i][1] is present or lower than it value is in arr2. If yes
/// add to res. Search fo index using binary search

/*
given two arrays
arr1 = { {1, 2000}, {2, 3000}, {3, 4000} }
arr2 = { { 1, 5000 }, {2, 3000} }
the first element of every pair represents id and the second value represents the value.
and a target x = 5000
Find the pairs from both the arrays whose vaue add upto a sum which is less than given target and should be closest to the target.
*/
public class OptimizeAirRoutes {
    public static void main(String[] args) {
        int arr1[][] =  { {1, 2000}, {2, 3000}, {3, 4000} };
        int arr2[][] = { { 1, 5000 }, {2, 3000} };
        int target = 5000;
        int res[][] = solve(arr1, arr2, target);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i][0]+"->"+res[i][1]);
        }
    }
    private static int[][] solve(int arr1[][], int arr2[][], int target){
        Arrays.sort(arr1, (a,b)->{
            return a[1]-b[1];
        });
        Arrays.sort(arr2, (a,b)->{
            return a[1]-b[1];
        });
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            int idx = binarySearch(arr2, target - arr1[i][1]);
            if(idx!=-1){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(arr1[i][0]);
                temp.add(arr2[idx][0]);
                res.add(temp);
            }
        }
        int result[][] = new int[res.size()][2];
        int i=0;
        for(ArrayList<Integer> li: res){
            result[i][0] = li.get(0);
            result[i][1] = li.get(1);
            i++;
        }
        return result;
    }
    private static int binarySearch(int arr[][], int target){
        int low = 0, high = arr.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid][1]== target){
                return mid;
            }
            else if(arr[mid][1]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        if(arr[low][1]<=target){
            return low;
        }
        return -1;
    }
}