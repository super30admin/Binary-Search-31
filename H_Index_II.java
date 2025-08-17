//Time Complexity : O(log n)
//Space Complexity : O(1)
public class H_Index_II {	
	public int hIndex(int[] citations) {
		/** Approach: Binary Search**/
        if(citations==null || citations.length==0) return 0;
        int n=citations.length;       
        int low=0;
        int high=n-1;        
        while(low<=high){
            int mid= low+(high-low)/2;
            if(citations[mid] == n-mid){
                return n-mid;
            } else if(citations[mid] > n-mid){
                high= mid-1;
            } else{
                low= mid+1;
            }            
        }        
        return n-low;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		H_Index_II ob = new H_Index_II();	
		//int[] citations = {0,1,3,5,6};
		int[] citations = {1,2,100};
		
		System.out.println("h-Index: "+ ob.hIndex(citations ));
	}	
}
