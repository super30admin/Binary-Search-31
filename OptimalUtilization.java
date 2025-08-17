// Time Complexity : O(m + n)
// Space Complexity : O(1)

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {2, 4}, {3, 6}};
        int[][] b = {{1, 2}};
        int target = 7;
        List<int[]> result = getOptimizedPairs(a, b, target);
        for(int[] res: result)
            System.out.println(res[0]+" "+res[1]);
    }
    
    public static List<int[]> getOptimizedPairs(int[][] a, int[][] b, int target){
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int first = 0;
        int second = 0;
        while(first < a.length){
            int sum = a[first][1] + b[second][1];
            System.out.println(sum);
            if(sum <= target){
                if(sum == max){
                    result.add(new int[]{a[first][0], b[second][0]});
                }
                else if(sum > max){
                    max = sum;
                    result.clear();
                    result.add(new int[]{a[first][0], b[second][0]});
                }
                second++;
                if(second == b.length){
                    first++;
                    second = 0;
                }
            }
            else{
                first++;
                second = 0;
            }
        }
        return result;
    }
}