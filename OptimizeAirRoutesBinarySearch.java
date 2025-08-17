// Time complexity = O(nlog(m))
// Space complexity = O(1)
public class OptimizeAirRoutesBinarySearch {
    static int[][] a = {{0,1000},{1, 1500}, {2, 2500}, {3, 4500}, {4, 5000}, {5, 6000}, {6, 7000}};
    static  int[][] b = {{0, 1500}, {1, 2000}, {2, 2500}, {3, 3500}, {4, 5000}, {5, 8000}};
    static int target = 7200;
    static int[] res;
    public static void main(String[] args) {
        // two sum problem
        // two pointer solution        
        for(int i=0;i< a.length;i++) {
            int complement = target - a[i][1];
            int low = 0;
            int high = b.length-1;
            int mid =0;
            res = new int[2];
        while(low <= high){
            mid = low + (high-low)/2;
            int num = b[mid][1];
            if(num < complement){
                if(mid < b.length-1){
                    // there is another element to the right
                    int next = b[mid+1][1];
                    if(next > complement){
                        res[1] = b[mid][0];
                        break;
                    } else {
                        low = mid+1;
                        break;
                    }
                } else {
                    // there is no element to the right and num is smaller
                    res[1] = b[mid][0];
                    break;
                }
            } else if (num == complement){
                res[1] = b[mid][0];
                break;
            } else {
                high = mid-1;
            }
        }
            res[0] = a[i][0];
        }
        System.out.println(res[0] + " "+ res[1]);
    }
}


