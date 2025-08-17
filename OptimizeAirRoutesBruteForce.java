// Time complexity = O(m*n), where m and n are length of the arrays.
// Space complexity = O(1)


public class OptimizeAirRoutesBruteForce {
    static int[][] a = {{1, 2000}, {2, 4000}, {3, 5000}};
    static  int[][] b = {{1,2000}};
    static int target = 7000;
    static  int near = 0;
    static  int[] res = new int[2];
    public static void main(String[] args) {
        // two sum problem
        for(int i=0;i< a.length;i++) {
            for(int j=0;j< b.length;j++) {                
                int sum = a[i][1] + b[j][1];
                if(sum <= target && sum >= near ) {
                    near = sum;
                    res[0] = a[i][0];
                    res[1] = b[j][0];
                }
            }
        }
        System.out.println(res[0] + " " +  res[1]);
    }
}