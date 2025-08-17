//Time complexity-O(mlogm+nlogm)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
import java.util.*;
import java.lang.Math.*;
class OptimalUtilization{
    int max=Integer.MIN_VALUE;
    public List<int[]> pathlist(int target, int[][] forwardPath, int[][] backwardPath){
        List<int[]> output= new ArrayList<>();
        Arrays.sort(backwardPath,(a,b) -> a[1]-b[1]);//sorting one of the array 
        for(int i=0;i<forwardPath.length;i++){
            int index=binarySearch(backwardPath,target-forwardPath[i][1]);
            if(index!=-1){
                    int sum=forwardPath[i][1]+backwardPath[index][1];
                    if(sum>=max){
                        if(sum>max){
                            output= new ArrayList<>();
                            max=sum;
                        }
                        output.add(new int[]{forwardPath[i][0],backwardPath[index][0]});
                    }
                }
            }
        return output;

    }
   public int binarySearch(int[][] arr, int target){//searching for target value or closest to it
       int low=0;
       int high=arr.length-1;
       while(low<=high){
           int mid=(low+high)/2;
            if(arr[mid][1]==target)
                return mid;
            else if(arr[mid][1]>target)
                high=mid-1;
            else
                low=mid+1;
       }
       return high;
   }

    public static void main(String args[]){
       int[][] a = new int[][] {{1, 200}, {2, 400}, {3, 600}};
       int[][] b = new int[][]{{1, 200},{2,300},{3,400}};
       int target = 600;

       OptimalUtilization obj = new OptimalUtilization();
      List<int[]> result= obj.pathlist(target, a, b);
      for(int i=0;i<result.size();i++){
             System.out.println(result.get(i)[0] +" "+ result.get(i)[1]);
        }
     

    }

}
