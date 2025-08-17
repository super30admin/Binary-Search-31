import java.util.*;
public class BinarySearch{
    //time complexity : logn
    // space complexity : 1
    // did it run on leetcode : yes
    // any doubts : no 
    //https://leetcode.com/problems/h-index-ii/
    public int hIndex(int[] citations) {
        
        int low = 0;
        int high = citations.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
          //  System.out.println("low-- " +low +" high-- "+high+" mid-- "+mid);
            if(citations[mid] == citations.length -mid){
                return citations.length-mid;
                
            }else if(citations[mid] > citations.length -mid){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return citations.length -low;
    }

   //time complexity : nlogn + mlogn
    // space complexity : 1
    // any doubts : no 
    //https://leetcode.com/discuss/interview-question/373202
    public List<int[]> optimalAirRoute(int[][]forward,int[][] backward, int target){

        List<int[]> output=new ArrayList<>();
 
        if(forward.length==0||backward.length==0||target==0){
 
            return output;
 
        }
 
        int max=0;
 
        Arrays.sort(backward,(a,b)->(a[1]-b[1]));
 
        for(int i=0;i<forward.length;i++){
 
            int index=binarySearch(backward,target-forward[i][1]);
 
            if(index!=-1){
 
                int sum=forward[i][1]+backward[index][1];
 
                if(sum>=max){
 
                    if(sum>max){
 
                        output=new ArrayList<>();
 
                    }
 
                    max=Math.max(max,sum);
 
                    output.add(new int[]{forward[i][0],backward[index][0]});
 
                }
 
            }
 
        }
 
        return output;
 
    }
 
    public int binarySearch(int[][] backward,int target){
 
        int left=0;
 
        int right=backward.length-1;
 
        while(left<right);
 
        int mid=left+(right-left)/2;
 
        if(backward[mid][1]==target){
 
            return mid;
 
        }
 
        else if(backward[mid][1]<target){
 
            left=mid;
 
        }
 
        else{
 
            right=mid-1;
 
        }
 
        return right;
 
    }
}