/*
TC: O(n*nlogn), max(arr1.length,arr2.length), nlogn for sorting the array.
SC: O(1)

Approach: here i will find the pair by using two pointers. Ptr1 at the start of the first element of arr1 and ptr2 at end of the arr2. at each iteration i willl check the minDiff encountered so far,according to my goal i will update the ptr1 and ptr2, if my total sum incresed by the target then i would want to 
decrease the sum by decreamenting the ptr2 and viceversa.
*/ 


class Optimize_Air_Routes{


    
    public static int[] primeAirTime(int[][] arr1, int[][] arr2, int k) {
        int[] res = new int[]{-1, -1};
        Arrays.sort(arr1, (a, b) -> a[1] - b[1]);
        Arrays.sort(arr2, (a, b) -> a[1] - b[1]);

        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = arr2.length - 1;
        while (i < arr1.length && j >= 0) {
            if (minDiff > Math.abs(k - arr1[i][1] - arr2[j][1])) {
                minDiff = Math.abs(k - arr1[i][1] - arr2[j][1]);
                res[0] = arr1[i][0];
                res[1] = arr2[j][0];
            }

            if(k >= arr1[i][1] + arr2[j][1])
                i++;
            else
                j--;
        }

        return res;
    }
}