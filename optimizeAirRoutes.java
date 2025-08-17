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