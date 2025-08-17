import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
There are 3 things to be known before attempting this problem: maxTravelDist,
it is an integer which represents the maximum operating travel distance of the given aircraft;
forwardRouteList, it is a list of pairs of integers where the first integer represents the unique
identifier of a forward shipping route and the second integer represents the amount of travel distance
required by this shipping route; returnRouteList, a list of pairs of integers where the first integer
represents the unique identifer of a return shipping route and the second integer represents the amount
of travel distance required by this shipping route.

These three things will be given as an input to you. you need to return a list of pairs of integers
representing the pairs of IDs of forward and also return the shipping routes that optimally utilize
the given aircraft. If no route is possible, return a list with empty pair.

Example 1: Input: maxTravelDist = 7000 forwardRouteList = [[1,2000],[2,4000],[3,6000]] returnRouteList = [[1,2000],[2, 3000]]

Output: [[2,1]]

Explanation: There are only three combinations [1,1],[2,1],and [3,1],
which have a total of 4000, 6000, and 8000 miles, respectively.
Since 6000 is the largest use that does not exceed 7000, [2,1] is the optimal pair.

Time Complexity: (N*M + (N+M)log(N+M)), N is the size of the forwardRoute List and M is the size of backwardRoute list
Space Complexity: O(1)
Approach:
1. Using Comparator class to arrange forwardRouter list in descending order and backwardRoute list in ascending order based
on their travel distance
2. I will be iterating through both of the routes and would add each travel distance, and compare the maxTravelDistance with
totalDistance travelled and will update my resultant accordingly
 */
public class OptimizeAirRoutes {

    public static List<List<Integer>> optimizedPath(List<List<Integer>> forwardRoute,
                                                    List<List<Integer>> backwardRoute,
                                                    int maxTravelDistance){

        forwardRoute = forwardRoute.stream().sorted((a,b)-> Integer.compare(b.get(1), a.get(1))).collect(Collectors.toList());
        backwardRoute = backwardRoute.stream().sorted((a,b)->Integer.compare(a.get(1), b.get(1))).collect(Collectors.toList());

        List<List<Integer>> result = new ArrayList<>();

        int maximumTravelledDistance = maxTravelDistance;

        while(true){
            for(List<Integer> forwardPath: forwardRoute){
                for(List<Integer> backwardPath: backwardRoute){
                    int totalDistance = forwardPath.get(1)+backwardPath.get(1);

                    if(totalDistance> maxTravelDistance){
                        break;
                    }
                    if(totalDistance == maxTravelDistance){
                        result.add(Arrays.asList(forwardPath.get(0),backwardPath.get(0), maximumTravelledDistance));
                        break;
                    }
                }
            }
            if(result.size()>0){
                break;
            }
            maximumTravelledDistance--;
        }
        return result.size()>0 ? result: new ArrayList<>();
    }
    public static void main(String[] args){
        List<List<Integer>> forwardRoute = new ArrayList<>();
        List<Integer> forward1 = new ArrayList<>();
        forward1.add(1);
        forward1.add(2000);
        forwardRoute.add(forward1);
        List<Integer> forward2 = new ArrayList<>();
        forward2.add(2);
        forward2.add(4000);
        forwardRoute.add(forward2);
        List<Integer> forward3 = new ArrayList<>();
        forward3.add(3);
        forward3.add(6000);
        forwardRoute.add(forward3);

        List<List<Integer>> returnRoute = new ArrayList<>();
        List<Integer> return1 = new ArrayList<>();
        return1.add(1);
        return1.add(3000);
        returnRoute.add(return1);
        List<Integer> return2 = new ArrayList<>();
        return2.add(2);
        return2.add(5000);
        returnRoute.add(return2);

        System.out.println("Optimized Route: "+optimizedPath(forwardRoute,returnRoute,7000));
    }
}
