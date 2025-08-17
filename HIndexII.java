class HIndexII {
    public int hIndex(int[] citations) {
        int n= citations.length;
        int low =0;
        int high =n-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            int diff = n-mid;
            if(diff == citations[mid])
            {
                return diff;
            }
            else if(diff > citations[mid])
            {
                low=mid+1;
            }
            else{
                high =mid-1;
            }
        }
        return n-low;
    }
}

//tc: O(log n)