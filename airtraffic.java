// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        
        List<int[]> res = getPairs(
    Arrays.asList(new int[]{1, 3}, new int[]{2, 5}, new int[]{3, 7}, new int[]{4, 10}),
    Arrays.asList(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{4, 5}),
    10
);
        System.out.println("1st ans");
        for(int i=0;i<res.size();i++){
            System.out.println("("+res.get(i)[0]+","+res.get(i)[1]+")");
        }
        System.out.println("2nd ans");
        res =getPairs(
    Arrays.asList(new int[]{1, 8}, new int[]{2, 15}, new int[]{3, 9}),
    Arrays.asList(new int[]{1, 8}, new int[]{2, 11}, new int[]{3, 12}),
    20);
        for(int i=0;i<res.size();i++){
            System.out.println("("+res.get(i)[0]+","+res.get(i)[1]+")");
        }
        
    }
    //two pointer solution
    private static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target){
        Collections.sort(a,(p,q)->p[1]-q[1]);
        Collections.sort(b,(p,q)->p[1]-q[1]);
        List<int[]> res=new ArrayList<>();
        int i=0,j=b.size()-1;
        int currtar=0,anstar=0;
        while(i<a.size()&& j>=0){
            currtar=a.get(i)[1]+b.get(j)[1];
            if(currtar<=target){
                if(currtar>anstar){
                    res.clear();
                    anstar=currtar;
                }
                else if(currtar<anstar){
                    continue;
                }
                res.add(new int[]{a.get(i)[0],b.get(j)[0]});
                i++;
            }
            else{
                j--;
            }
        
        }
        return res;                
    }
}
