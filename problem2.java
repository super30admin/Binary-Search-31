public class problem2 {

    //Linear Search
    // Time Complexity: 0(n)
    // Space Complexity:0(1)
    public int hIndex1(int[] citations) {
        int n= citations.length;
        for(int i=0;i<n;i++)
        {
            int diff= n-i;
            if(diff<= citations[i])
            {
                return diff;
            }
        }
        return 0;

    }
    //Binary Search
    // Time Complexity: 0(log(n))
    // Space Complexity:0(1)
    public int hIndex (int[] citations) {
        int n= citations.length;
        int low=0, high= n-1;
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            int diff= n-mid;
            if(diff==citations[mid])
            {
                return diff;
            }
            else if(diff>=citations[mid])
            {
                low=mid+1;
            }
            else
            {
                high= mid-1;
            }
        }
        return n-low;
    }
}
