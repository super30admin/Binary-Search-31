public class FlightDistance {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[][] fRoute = {{1,2000},{2,3000},{3,6000}};
        int[][] bRoute = {{1,2000},{2,4000}};
        shortestPath(fRoute, bRoute, 7000);
    }
    
    // TC is O(m+n) where m and n are number of routes forward and backward respectively
    // SC constant
    private static void shortestPath(int[][] fRoute, int[][] bRoute, int maxDist){
        int max=Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        for(int[] route1: fRoute){
            for(int[] route2: bRoute){
                 li = new ArrayList<>();
                int currMax = route1[1]+route2[1];
                if(currMax > max && currMax <= maxDist){
                    result = new ArrayList<>();
                    max = currMax;
                    li.add(route1[0]);
                    li.add(route2[0]);
                    result.add(li);
                }else if(currMax == max){
                    li.add(route1[0]);
                    li.add(route2[0]);
                    result.add(li);
                }
                
            }
            
        }
        for(List<Integer> res: result){
            System.out.println(res.get(0)+" "+res.get(1));
        }
    }
}
