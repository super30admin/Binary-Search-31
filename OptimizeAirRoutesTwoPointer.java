// Time complexity = O(m+n) = O(max(m,n))
// Space complexity = O(1)

public class OptimizeAirRoutesTwoPointer {
    static int[][] a = {{0,1000},{1, 1500}, {2, 2500}, {3, 4500}, {4, 5000}, {5, 6000}, {6, 7000}};
    static  int[][] b = {{0, 1500}, {1, 2000}, {2, 2500}, {3, 3500}, {4, 5000}, {5, 8000}};
    static int target = 7200;
    static int[] res;
    public static void main(String[] args) {
        // two sum problem
        // two pointer solution
        int i=0;
        int j = b.length-1;
        while(i<= a.length-1 && j>=0) {
            int sum = (a[i][1] + b[j][1]);
            if( sum <= target) {
                if(sum == target) {
                    res= new int[]{a[i][0], b[j][0]};
                    i++;
                    j--;      
                    return;
                } else {
                    res= new int[]{a[i][0], b[j][0]};
                    i++;
                }
            } else if(sum > target) {
                j--;
            } else { // sum ==target
                i++;
                j--;
            }
        }
        System.out.println(res[0] + " "+ res[1]);
    }
}