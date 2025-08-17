//Time Complexity=O(MN)
//Space Complexity=O(1)
import java.util.ArrayList;
import java.util.Collections;

public class OptimizeAirRoutes {

    private static ArrayList<int[]> getRoutes(ArrayList<int[]> a,ArrayList<int[]>b,int target){
        Collections.sort(a,(i,j)->i[1]-j[1]);
        Collections.sort(b,(i, j)->i[1]-j[1]);
        ArrayList<int[]> result=new ArrayList<>();
        int n=a.size();int m=b.size();
        int max=0,i=0,j=m-1;
        while(i<n && j>=0){
            int[] f=a.get(i);
            int[] r=b.get(j);
            int sum=f[1]+r[1];
            if(sum<=target){
                if(max<sum){
                    result=new ArrayList<>();
                    max=sum;
                }
                result.add(new int[]{f[0],r[0]});
                i++;
            }else{
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //System.out.println("Hello World!");
        ArrayList<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 8});
        a.add(new int[]{2, 15});
        a.add(new int[]{3, 9});

        ArrayList<int[]> b = new ArrayList<>();
        b.add(new int[]{1, 8});
        b.add(new int[]{2, 11});
        b.add(new int[]{3, 12});
        int target=20;
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
