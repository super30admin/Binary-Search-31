// Time Complexity :O(nlogn) to sort both route arrays
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


import java.util.*;
public class MyClass {
    public static void main(String args[]) {
     int [][] forwardRoutes = {{1,8},{2,15},{3,9}};  // replace with input
     int [][] backwardRoutes = {{1,8},{2,11},{3,12}};  // replace with input
     int target = 20;    //replace with input
     
     List<List<Integer>>res = getOptimumRoute(target, forwardRoutes, backwardRoutes);
     for(List<Integer> temp :res)  // Printing Answers
     System.out.println(temp);
     
    }
    
    private static List<List<Integer>> getOptimumRoute(int target, int[][]f, int[][] b)
    {
        Arrays.sort(f, (a,c)->{return a[1]-c[1];});
        Arrays.sort(b, (a,c)->{return a[1]-c[1];});
        
        int start =0, end =b.length-1 , maxVal = Integer.MIN_VALUE;
        ArrayList<List<Integer>> result = new ArrayList<>(); 
        
        while(start<f.length && end>=0)
        {
            int val1 = f[start][1];
            int val2 = b[end][1];
            int sum = val1+val2;
            
            if(sum==maxVal)
              {
                  ArrayList<Integer> temp = new ArrayList<>();
                  temp.add(f[start][0]);
                  temp.add(b[end][0]);
                  result.add(temp);
              }
            if(sum<=target && sum>maxVal)
            {
                result.clear();
                maxVal= sum;
                ArrayList<Integer> temp = new ArrayList<>();
                  temp.add(f[start][0]);
                  temp.add(b[end][0]);
                  result.add(temp);
                
               
            }
             if(sum>target)
            {end--;}
             if(sum<target)
             {start++;}
            if(sum==target)
            {
                start++; end--;
            }
        }
        
        return result;

    }
}