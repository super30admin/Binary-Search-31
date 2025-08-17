// Time Complexity O(m + n)
// Space Complexity O(1)

class Solution{

    public List<int[]> optimalAirRoute(int[][]forward,int[][] backward, int target){
        List<int[]> result = new ArrayList<int[]>();

        int dist = 1;
        int route = 0;

        int p1 = 0;
        int p2 = backward.length -1;

        int[] bestRoute = new int[]{0,0};
        int bestDist = 0;

        while(p1 < forward.length && p2 >= 0){

            int[] forw = forward[p1];
            int[] back = backward[p2];

            if( forw[dist] + back[dist] <= target ){

                if(forw[dist] + back[dist] == target){
                    result.add( new int[] {forw[route], back[route] });
                    p1++;
                }else{
                    p1++;
                }
                if( forw[dist] + back[dist] >= bestDist && forw[dist] + back[dist] <= target){
                    bestDist = forw[dist] + back[dist];
                    bestRoute[0] = forw[route];
                    bestRoute[1] = back[route];
                }

            }else{
                p2--;
            }
        }

        if(result.size() == 0){
            result.add( new int[] {bestRoute[0], bestRoute[1] });
        }

        return result;
    }

    public static void main(String[] args){

        Solution s =new Solution();

        int[][] forward= {{1, 2000}, {2, 5000}, {3, 5000}, {4, 4000}};

        int[][] backward={{1, 2000}};

        int target=7000;

        List<int[]> res=s.optimalAirRoute(forward,backward,target);

        if(res!=null){

            for(int i=0;i<res.size();i++){

                System.out.println(res.get(i)[0]+","+res.get(i)[1]);

            }

        }

    }

}

