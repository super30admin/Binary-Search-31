//Problem 89 : Air Routes 
//TC: mlog(n) where n will be that list which is bigger in size and m will be the smaller list
//SC: O(1)

/*
Similar to Two Sum
Bruteforce: TC: O(n^2). Just Iterate over returnRoutes array for each forwardRoute array. For each calculate thr total distance. If total distance is less than or equal to the threshold. perform below steps:
               a) If total is greater than the global max, then clear the result array, add forwardRoute and returnRoute id in the result list and update max to the total;
               b) If total is equal to the max, then just add the add forwardRoute and returnRoute id in the result list.  

Optimized: If array is sorted or sorting is allowed
           1) Two Pointers : TC:O(n+m) | SC:O(1) . Put low pointer on forwardRoute first index and high pointer at returnRoute last index.
              a) If sum of low and right pointer elements is greater than the threshold, decrement the high pointer.
              b) If sum of low and right pointer elements is lesser than the threshold, add the ids in the result and update the max, then increment the low pointer.
              c) If sum of low and right pointer elements is equal to the threshold, just record the ids and move both the pointers

           2) Binary Search : TC: O(nlogm) | SC:O(1) . Implement BS over the longest array for each element of the smaller array. Then BS similar to two pointers i.e if total is <= threshold record the ids and move start to mid+1 otherwise move end to mid-1
*/

import java.util.*;
public class AirRoutes {
    
    private static Integer maxVal = Integer.MIN_VALUE;
    
    //Binary Search

    private static List<List<Integer>> getOptimizedRoute(int threshold, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList ){
     
     List<List<Integer>> result = new ArrayList<>();
  
     //Implement Binary Search on the list/array which is of larger size
     if(forwardRouteList.size()>returnRouteList.size()){
         getResult(threshold,forwardRouteList,returnRouteList,result,true);
     }else{
         getResult(threshold,returnRouteList,forwardRouteList,result,false);
     }   
            
        
     return result;
     
 }
    
    
   //BinarySearch
    private static void getResult(int threshold, List<List<Integer>> binarySearchList, List<List<Integer>> list, List<List<Integer>> result,boolean forwardBS){
        
        for(int i=0;i<list.size();i++){
            
            int start = 0;
            int end   = binarySearchList.size()-1;
            int route1 = list.get(i).get(1);//forward
            
            while(start<=end){
                
                int mid = start + (end-start)/2;
                int route2 = binarySearchList.get(mid).get(1);
                int total = route1+route2;
                if(total<=threshold){
                    
                    int route1Id = list.get(i).get(0);
                    int route2Id = binarySearchList.get(mid).get(0);
                    
                    if(total==maxVal){
                        if(forwardBS){//bs is on forwardRoute
                           result.add(Arrays.asList(route2Id,route1Id));    
                        }else{//bs is on returnRoute
                           result.add(Arrays.asList(route1Id,route2Id));
                        }
                        
                    }else if(total>maxVal){
                        result.clear();
                         if(forwardBS){//bs is on forwardRoute
                           result.add(Arrays.asList(route2Id,route1Id));    
                        }else{//bs is on returnRoute
                           result.add(Arrays.asList(route1Id,route2Id));
                        }
                         
                        maxVal = total;
                    }
                    start = mid+1;
                }else{
                    end = mid-1;
                }
                
            }
            
        }
        
    }

    public static void main(String[] args) {
        
        List<List<Integer>> forwardRouteList= new ArrayList<>();
        List<List<Integer>> returnRouteList= new ArrayList<>();
        
        //IP1
        int maxTravelDist=7000;
        List<Integer> forwardList1 = new ArrayList<>();
        forwardList1.add(1);
        forwardList1.add(2000);
        forwardRouteList.add(forwardList1);
        
        List<Integer> forwardList2 = new ArrayList<>();
        forwardList2.add(2);
        forwardList2.add(4000);
        forwardRouteList.add(forwardList2);
        
        List<Integer> forwardList3 = new ArrayList<>();
        forwardList3.add(3);
        forwardList3.add(6000);
        forwardRouteList.add(forwardList3);
        
        List<Integer> returnList1 = new ArrayList<>();
        returnList1.add(1);
        returnList1.add(2000);
        returnRouteList.add(returnList1);
        
        //IP2
        /*int maxTravelDist=10000;
        List<Integer> forwardList1 = new ArrayList<>();
        forwardList1.add(1);
        forwardList1.add(3000);
        forwardRouteList.add(forwardList1);
        
        List<Integer> forwardList2 = new ArrayList<>();
        forwardList2.add(2);
        forwardList2.add(5000);
        forwardRouteList.add(forwardList2);
        
        List<Integer> forwardList3 = new ArrayList<>();
        forwardList3.add(3);
        forwardList3.add(7000);
        forwardRouteList.add(forwardList3);
        
        List<Integer> forwardList4 = new ArrayList<>();
        forwardList4.add(4);
        forwardList4.add(10000);
        forwardRouteList.add(forwardList4);
        
        List<Integer> returnList1 = new ArrayList<>();
        returnList1.add(1);
        returnList1.add(2000);
        returnRouteList.add(returnList1);
        
        List<Integer> returnList2 = new ArrayList<>();
        returnList2.add(2);
        returnList2.add(3000);
        returnRouteList.add(returnList2);
        
        List<Integer> returnList3 = new ArrayList<>();
        returnList3.add(3);
        returnList3.add(4000);
        returnRouteList.add(returnList3);
        
        List<Integer> returnList4 = new ArrayList<>();
        returnList4.add(4);
        returnList4.add(5000);
        returnRouteList.add(returnList4);*/
        
        System.out.println("Forward "+forwardRouteList);
        System.out.println("Return "+returnRouteList);
        
        System.out.println(getOptimizedRoute(maxTravelDist,forwardRouteList,returnRouteList));
    }
    
    
    
    //Bruteforce
    //TC: O(n^2)
    /*private static List<List<Integer>> getOptimizedRoute(int threshold, List<List<Integer>> forwardRouteList, List<List<Integer>> returnRouteList ){
     
     List<List<Integer>> result = new ArrayList<>();
     int max = Integer.MIN_VALUE;
     for(int i=0;i<forwardRouteList.size();i++){
         for(int j=0;j<returnRouteList.size();j++){
             int forwardDist = forwardRouteList.get(i).get(1);
             int returnDist =  returnRouteList.get(j).get(1);
             
             int total = forwardDist+returnDist;
             
             if(total<=threshold){
                 
                 int forwardId = forwardRouteList.get(i).get(0);
                 int returnId  = returnRouteList.get(j).get(0);
                 
                 if(total==max){
                     result.add(Arrays.asList(forwardId,returnId));
                 }else if(total>max){
                     result.clear();
                     result.add(Arrays.asList(forwardId,returnId));
                     max = total;
                 }
                 
             }
             
         }
     }
     
     return result;
     
 }*/


    
    
}

 
/*If used the concept of Pair
static class Pair{
        int id;
        int dist;
        
        Pair(int id, int dist){
            this.id = id;
            this.dist = dist;
        }
    }

     List<Pair> forwardRoutePair= new ArrayList<>();
        List<Pair> returnRoutePair= new ArrayList<>();
        forwardRoutePair.add(new Pair(1,2000));
        forwardRoutePair.add(new Pair(2,4000));
        forwardRoutePair.add(new Pair(3,6000));
        
        returnRoutePair.add(new Pair(1,2000));

*/