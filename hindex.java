class Solution {
    public int hIndex(int[] citations) {
        /*if(citations==null || citations.length==0)return 0;
        int n=citations.length;
        for(int i=0;i<n;i++){
            if(citations[i]>=n-i)return n-i;
        }
        return 0;*/
        int n=citations.length;
        int l=0,h=n-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(citations[m]==n-m)return n-m;
            else if(citations[m]<n-m)l=m+1;
            else h=m-1;


        }
        return n-l;
    }
}