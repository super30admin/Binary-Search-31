//Time complexity : O(m+n) //sizes of input Arrays
//Space complexity : constant


// "static void main" must be defined in a public class.
public class Main {

    public static List<Integer> AirRoutes(int[][] forward, int[][] backward, int capacity)
    {
        //pointer on forward and backward array
        int fwd = 0;
        int bwd = backward.length-1;
        int maxSum = Integer.MIN_VALUE;
        int r1=0, r2=0;

        while(fwd < forward.length && bwd >= 0)
        {
            int sum = forward[fwd][1] + backward[bwd][1];
            if(sum==capacity)
                return new ArrayList<>(Arrays.asList(fwd,bwd));

            else if(sum < capacity)
            {
                if(sum > maxSum)
                {
                    maxSum = sum;
                    r1 = fwd;
                    r2 = bwd;
                }
                fwd++;
            }
            else
                bwd--;
        }

        return new ArrayList<>(Arrays.asList(r1,r2));

    }

    public static void main(String[] args) {

        int[][] forward = {{1,2000},{2,4000},{3,4000}};
        int[][] backward = {{1,2500},{2,2000}};

        List<Integer> answer = AirRoutes(forward, backward, 5000);

        for(int i : answer)
            System.out.println(i+" ");
    }
}
