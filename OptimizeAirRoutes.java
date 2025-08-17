import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Time Complexity : O(n log m)
//Space Complexity :O(n) //map size
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
 * 1. For each source city find the closest possible destination combination using binary search.
 * 2. return the closest combination for the target.
 */

public class OptimizeAirRoutes {
	private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target){
		
		Map<Integer, List<int[]>> resultMap=new HashMap<>();
		
		
		int[] sou=new int[a.size()];
		int[] ret=new int[b.size()];
		
		for (int[] arr : a) {
			sou[arr[0]-1]=arr[1];
		}
		
		for (int[] arr : b) {
			ret[arr[0]-1]=arr[1];
		}
		
		int high=0;
		for (int i=0;i<sou.length;i++) {
			int soudis=sou[i];
			int index=binarySearch(0, ret.length, ret, target-soudis);
			if(index>-1) {
				resultMap.computeIfAbsent(soudis+ret[index], k-> new ArrayList<int[]>()).add(new int[] {i+1,index+1});
				high=Math.max(high, soudis+ret[index]);
			}
		}
		
		return resultMap.get(high);
	}
	
	private int binarySearch(int low,int high,int[] arr,int target) {
		while(low<high) {
			int mid = low+(high-low)/2;
			if(arr[mid]==target) {
				return mid;
			}
			else if(arr[mid]>target) {
				high=mid;
			}else {
				low=mid+1;
			}
		}
		return low-1;
	}
	
	public static void main(String[] args) {
				
		List<int[]> sou = new ArrayList<>();
		sou.add(new int[] {1,8});
		sou.add(new int[] {2,15});
		sou.add(new int[] {3,9});
		
		List<int[]> des = new ArrayList<>();
		des.add(new int[] {1,8});
		des.add(new int[] {2,11});
		des.add(new int[] {3,12});
		int target = 20;
		
		List<int[]> result= new OptimizeAirRoutes().getPairs(sou, des, target);
		for (int[] arr : result) {
			System.out.println(Arrays.toString(arr));				
		}
		
	}
}
