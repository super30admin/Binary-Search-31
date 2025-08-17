// "static void main" must be defined in a public class.
public class Main {
    
    // Time Complexity: Max(n,m)log m
    // Space Complexity: O(1)
    
    public static void main(String[] args) {
        int[][] A = {{1,2000},{2,4000},{3,6000}};   // n
        int[][] B = {{1,2000},{2,4000},{3,6000}};   // m
        int target = 13000;
        
        List<int[]> result = new ArrayList<>();
        Arrays.sort(B, (a,b) -> a[1] - b[1]);   // m log m
        int maxVal = Integer.MIN_VALUE;
        
        
        // n log m
        for(int i = 0; i < A.length; i++){
            int curr = A[i][1];
            int index = binarySearch(B, target - curr);
            
            if(index != -1){
                int sum = curr + B[index][1];
                if(sum >= maxVal){
                    if(sum > maxVal){
                        result = new ArrayList<>();
                        maxVal = sum;
                    }
                    result.add(new int[]{A[i][0], B[index][0]});
                }
            }
        }
        for(int[] el : result){
            System.out.println(el[0] + "," + el[1]);
        }
    }
    
    // Function to find binary Search
    private static int binarySearch(int[][] B, int target){
        int low = 0;
        int high = B.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(B[mid][1] == target)
                return mid;
            else if(B[mid][1] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }
}