import java.util.ArrayList;
import java.util.Collections;

public class OptimizeAirRoutesBinarySearch {

    private static ArrayList<int[]> getRoutes(ArrayList<int[]> a, ArrayList<int[]>b, int target){
        Collections.sort(a,(i, j)->i[1]-j[1]);
        Collections.sort(b,(i,j)->i[1]-j[1]);
        ArrayList<int[]> result=new ArrayList<>();
        int n=a.size();int m=b.size();
        int max=0;

        for(int i=0;i<n;i++){
            int[] route=a.get(i);
            int[] reRoute=bSearch(route[1],b,target);
            int sum=route[1]+reRoute[1];
            if(sum<=target){
                if(max<sum){
                    result=new ArrayList<>();
                    max=sum;
                }
                result.add(new int[]{route[0],reRoute[0]});
            }

        }

        return result;
    }
    private static int[] bSearch(int route,ArrayList<int[]> b,int target){
        int n=b.size();
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int[] path=b.get(mid);
            int reRoute= path[1];
            int sum=reRoute+route;
            if(sum==target){
                return path;
            }else if(sum<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(low==0){
            return b.get(low);
        }
        return b.get(low-1);
    }
    public static void main(String[] args) {

        //System.out.println("Hello World!");
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 3});
        a.add(new int[]{2, 5});
        a.add(new int[]{3, 7});
        a.add(new int[]{4, 10});

        ArrayList<int[]> b = new ArrayList<>();
        b.add(new int[]{1, 2});
        b.add(new int[]{2, 3});
        b.add(new int[]{3, 4});
        b.add(new int[]{4, 5});
        int target=10;
        ArrayList<int[]> c=getRoutes(a,b,target);
        for(int[] arr:c){
            //System.out.println(arr);
            for(int i:arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
