class Sample{
    /**************PROBLEM-1***************/
    //tc:0(N*M)
    //SC:0(1)
    public int[][] Solution(int[] a,int[] b,int target){
        if(a==null || b==null || a.length==0 ||b.length==0){
            return new int[][]{};
        }
        int n=a.length,m=b.length,max=0;
        int[] result=new int[1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int dist=a[i][1]+b[j][1];
                if(dist>max && dist<=target){
                    max=dist;
                    result[0]= new int[]{a[i][0],b[j][0]};
                }
            }
        }
        return result;
    }

//TC:0(mLogm+nLogn)
    //SC:0(1)
    public List<List<Integer>> Solution(int[] a,int[] b,int target){
        if(a==null || b==null || a.length==0 ||b.length==0){
            return new int[][]{};
        }
        int n=a.length,m=b.length,max=0;
        List<List<Integer>> result=new ArrayList<>();
        int left=0,right=m-1,max=0;
        Arrays.sort(a);
        Arrays.sort(b);
        while(left<n && right>-1){
            int value=a[left][1]+b[right][1];
            if(value==target) {
                result.add(a[left][0]+b[right][0]);
            }
                left++;
                right--;
            }else if(value<target){
                if(value>max && value<target){
                    result.add(a[left][0]+b[right][0]);
                }
                left++;
            }else{
                right--;
            }
        }
        return result;
    }


    /**********************PROBLEM2***************/

    //TC:0(N)
//SC:0(1)
    class Solution {
        public int hIndex(int[] citations) {
            if(citations.length==0 || citations==null){
                return -1;
            }
            int n=citations.length;
            for(int i=0;i<n;i++){
                if(citations[i]>=n-i){
                    return n-i;
                }
            }
            return 0;
        }
    }

//TC:0(LogN)
//SC:0(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0 || citations==null){
            return -1;
        }
        int n=citations.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(citations[mid]>=n-mid){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return n-low;
    }
}

}