//Time Complexity=O(logn)
//Space Complexity=O(1)
public class HIndexII {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int difference=n-mid;
            if(difference==citations[mid]){
                return citations[mid];
            }else if(difference<citations[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return n-low;
    }
}
