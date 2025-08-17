import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity : O(m+n)
//Space Complexity : O(1)
public class PrimeAirTime {	
	/**Approach: Two Pointers**/
	public List<int[]> primeAirTime(int[][] arr1, int[][] arr2, int target){
        List<int[]> result= new ArrayList<>();
        if(arr1==null || arr2==null) return result;        
       
        int m= arr1.length; int n= arr2.length;   
        int low= 0; //start of first array
        int high= n-1; //end of second array 
        int diff= Integer.MAX_VALUE;
        
        while(low<m && high>=0){
            int curMiles= arr1[low][1]+ arr2[high][1];    
            if(curMiles > target){
                high--;
            }else{               	
                if(diff > target-curMiles){ //overwrite the result if better pair found                    
                    result= new ArrayList<>();
            	}
            	            	
            	//Adding to result for similar or better pairs
            	if(curMiles==target || diff == target-curMiles) { 
            		diff= target-curMiles;
                	//to handle duplicate pairs with same miles
                	int p1= high;
                	while(p1>=0 && arr2[p1][1]==arr2[high][1]) {
                		result.add(new int[]{arr1[low][0], arr2[p1][0]}); 
                		p1--;
                	}
                } else if(diff > target-curMiles){
                	diff= target-curMiles;
                    result.add(new int[]{arr1[low][0], arr2[high][0]}); 
                    
                }                         
                
                low++; 
            }            
        }
        return result;
    }  	

	// Driver code to test above
	public static void main (String[] args) {
		PrimeAirTime ob = new PrimeAirTime();	
		/*int[][] arr1 = { {1, 2000}, {2, 3000}, {3, 4000} };
        int[][] arr2 = { { 1, 3000 }, {2, 5000} };
        int x=5000;*/
		int[][] arr1 = {{1, 1000}, {2, 2000}, {3, 3500}, {4, 4500}, {5, 6000}};
        int[][] arr2 = {{1, 500 }, {2, 1000}, {3, 2500}, {4, 3000}, {5, 3500}, {6, 5000}};
        int x=7500;
		/*int[][] arr1 = {{1, 1000}, {2, 1000}, {3, 2000}, {4, 3000}, {5, 6000}, {6, 9000}};
        int[][] arr2 = {{1, 2000 }, {2, 3000}, {3, 5000}, {4, 6000}, {5, 6000}, {6, 7000}, {7, 8000}};
        int x=7000;*/
        
        List<int[]> list= ob.primeAirTime(arr1, arr2,x);
        System.out.println("Pairs closest to the target:");
        for(int[] l: list){
             System.out.println(Arrays.toString(l));
        }
	}	
}
