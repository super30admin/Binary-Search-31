// Amazon | OA 2019 | Optimal Utilization - https://leetcode.com/discuss/interview-question/373202
// Time Complexity : O(nlogn + mlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
public class Main
{
private static List<List<Integer>> optimalRoutes(int target, int[][] forwardRoutes, int[][] returnRoutes) 
{
     List<List<Integer>> result = new ArrayList<>();

		if (forwardRoutes == null || forwardRoutes.length == 0 || returnRoutes == null || returnRoutes.length == 0) {
			return result;
		}

		Arrays.sort(forwardRoutes, (a, b) -> a[1] - b[1]);
		Arrays.sort(returnRoutes, (a, b) -> a[1] - b[1]);

		int maxDistance = 0;

    for(int i=0;i<forwardRoutes.length;i++)
    {
        int remainingDistance=target-forwardRoutes[i][1];

        int index=binarySearch(returnRoutes,remainingDistance);

        if(index == -1) 
        {
          continue;
        }

        int total=forwardRoutes[i][1]+returnRoutes[index][1];

        if(total> maxDistance)
        {
            maxDistance=total;
            result=new ArrayList<>();
        }

        if(maxDistance == total)
        {
         result.add(new ArrayList<>(Arrays.asList(forwardRoutes[i][0],returnRoutes[index][0])));
        }
    }
    return result;

}

   private static int binarySearch(int[][] routes, int target) {
		int low = 0;
		int high = routes.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (routes[mid][1] == target) {
				return mid;
			} else if (routes[mid][1] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return high;
	}

    public static void main(String[] args) {
        int[][] forwardRoutes = new int[][]{{1,1000},{2,2000},{3,3000},{4,4500},{5,6000}};
        int[][] returnRoutes= new int[][]{{1,2000},{2,3500},{3,4500},{4,6500}};

        List<List<Integer>> result = optimalRoutes(7000,forwardRoutes,returnRoutes);

        System.out.println("reached"+result.size());
        if(result.size()!=0) {
            for(int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).get(0)+ ", " +result.get(i).get(1));
            }
        }
    }

}