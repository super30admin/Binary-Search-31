/*
method1 - try all possible combinations, O(mxn)
method 2 - 2 pointer approach since the distances are sorted
time complexity: O(m+n)

method 3 - iterate smaller array and do binary search on bigger array
time complexity : mlogn.
 */

import java.util.*;
class DistPair{
    int id;
    int distance;
    DistPair(){}
    DistPair(int id, int distance){
        this.id = id;
        this.distance = distance;
    }
}

public class OptimiseRoutes {
    public  List<Integer> OptimiseAirRoutes(List<DistPair>forward, List<DistPair>backward,int target){

       List<Integer>routeList = new ArrayList<>();

        int ptr1 = 0;
        int ptr2 = backward.size()-1;

        int maxDist = Integer.MIN_VALUE;
        DistPair p1 = new DistPair();
        DistPair p2 = new DistPair();
        while(ptr1 <= forward.size()-1 && ptr2 >= 0){
            int currDist = forward.get(ptr1).distance + backward.get(ptr2).distance;
            if (currDist <= target){
                maxDist = Math.max(maxDist, currDist);
                p1 = forward.get(ptr1);
                p2 = backward.get(ptr2);

                ptr1++;
            }else{
                ptr2--;
            }

        }

        routeList.add(p1.id);
        routeList.add(p2.id);

        return routeList;
    }


}

class RoutesMain{

    public static void main(String[] args) {
        DistPair p1 = new DistPair(1,2000);
        DistPair p2 = new DistPair(2,4000);
        DistPair p3 = new DistPair(3,6000);

        List<DistPair> forward =  new ArrayList<>();
        forward.add(p1);forward.add(p2);forward.add(p3);

        DistPair p4 = new DistPair(1,2000);
        List<DistPair> backward =  new ArrayList<>();
        backward.add(p4);

        int target = 7000;

        OptimiseRoutes o1 = new OptimiseRoutes();

        List<Integer>result = o1.OptimiseAirRoutes(forward,backward,target);
        System.out.println(result);


    }
}
