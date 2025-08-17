public class HIndex {
    // TC is O(logn) where n is the number of papers
    // SC constant
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length-1;
        int mid=0;
        int tar = 0;
        while(low<=high){
            mid = low+(high-low)/2;
            tar = citations.length-mid;
            if(citations[mid] == tar) return tar;
            if(citations[mid] < tar) {
                
                    low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return (citations.length)-low;
    }
}
