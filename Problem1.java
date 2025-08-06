
/* 
 * Position: SDE 1
Location: Bengaluru, India.
YoE: 1 year 3 months.
Platform: Hackerrank

Problem:
This problem is a variant of closest pair sum. You'll be given two arrays
arr1 = { {1, 2000}, {2, 3000}, {3, 4000} }
arr2 = { { 1, 5000 }, {2, 3000} }
the first element of every pair represents id and the second value represents the value.
and a target x Find the pairs from both the arrays whose vaue add upto a sum which is less than given target and should be closest to the target.
= 5000

Output for the above example:
{ {1, 2} } // Note that the output should be in id's

I cleared all the test cases for the first problem (will share), but for this problem, I couldn't clear 3 test cases which were of handling duplicates!
In the online assesment this problem was sort of tagged as approximate solution, does anyone know what that means?
Awaiting for the result!
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {

   

    public static void main(String[] args) {
        int arr1[][] = { {1, 2000}, {2, 3000}, {3, 4000}, {4, 2000} };
        int arr2[][] = { { 1, 5000 }, {2, 3000} };

        List<int[]> re = getClosestPairs(arr1, arr2, 5000);

        for(int[] pair : re) {
            System.out.println("{" + pair[0] + ", " + pair[1] + "}");
        }
        System.out.println("Time Comlexity for getClosestPairs() solution is O(n^2) where n is the number of elements in the array ");
            

        List<int[]> reOptimized = getClosestPairsOptimized(arr1, arr2, 5000);
        for(int[] pair : reOptimized) {
            System.out.println("{" + pair[0] + ", " + pair[1] + "}");
        }
        System.out.println("Time Comlexity for getClosestPairsOptimized() solution is O(n log n) where n is the number of elements in the array ");
    }
    public static List<int[]> getClosestPairs(int[][] arr1, int[][] arr2, int target) {
        // Your implementation here
        // Find the pairs from both the arrays whose vaue add upto a sum which 
        // is less than given target and should be closest to the target.
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] p : arr1){
            int id = p[0];
            int value = p[1];
            map.put(id, value);
        }
      



        int closestSum = Integer.MIN_VALUE;
        List<int[]> result = new ArrayList<>();

        for(int[] p : arr2){
            int id = p[0];
            int value = p[1];

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int sum = entry.getValue() + value;
              // System.out.println("Sum: " + sum + " for pair: " + entry.getKey() + ", " + id);
                if(sum <= target && sum >= closestSum && closestSum<= target){
                    closestSum = sum;
                    result.add(new int[]{entry.getKey(), id});
                }
            }
        }

        return result;
    }

    public static List<int[]> getClosestPairsOptimized(int[][] arr1, int[][] arr2, int target) {
        // Your implementation here
        // Find the pairs from both the arrays whose vaue add upto a sum which 
        // is less than given target and should be closest to the target.
        
        List<int[]> result = new ArrayList<>();
        int closestSum = Integer.MIN_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] p : arr1){
            int id = p[0];
            int value = p[1];
            map.put(value, id);
        }

        //finding the closest search for the second array
        for(int[] p : arr2){
            int id = p[0];
            int value = p[1];

            int findElement = target - value;
            if( map.containsKey(findElement)){
                int[] pair = {map.get(findElement), id};
                result.add(pair);
            }
            else {
                int closestValue = Integer.MAX_VALUE;
                for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                    int sum = entry.getKey() + value;
                    if(sum <= target && sum <= closestSum && closestSum<= target){
                        closestSum = sum;
                        closestValue = entry.getKey();
                    }
                }
                if(closestValue != Integer.MAX_VALUE) {
                    result.add(new int[]{map.get(closestValue), id});
                }
            }
            
        }

        return result;
    }
}
