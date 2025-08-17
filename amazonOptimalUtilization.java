//Time complexity O((n))
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
package Default;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class amazonOptimalUtilization {
	
	private static List calculateCloseElement(List<int[]> num1, List<int[]> num2, int target) {
		
		List<Integer> result = new ArrayList<>();
		List<List<Integer>> result1 = new ArrayList<>();
		
		if(num1.size() == 0 || num2.size() == 0) {
			
			return result;
		}
		
		if(num1.size() > num2.size()) {
			
			return calculateCloseElement(num2, num1, target);
		}
		
		Collections.sort(num1, (a,b)-> a[1] - b[1]);
		Collections.sort(num2, (a,b)->a[1] - b[1]);
		
		int l1 = 0;
		int l2 = num1.size() - 1;
		int r1 = 0;
		int r2 = num2.size() - 1;
		boolean found = false;
		int temp = Integer.MIN_VALUE;
		
		while(l1 <= l2 && r2 >= r1) {
			
			if(num1.get(l1)[1] + num2.get(r2)[1] == target) {
				
				//System.out.println("hello" + num1.get(l1)[1] +"+"+ num2.get(r2)[1] );
				List<Integer> tempResult1 = new ArrayList<>();
				tempResult1.add(num1.get(l1)[0]);
				tempResult1.add(num2.get(r2)[0]);
				//System.out.println(result);
				result1.add(new ArrayList<Integer> (tempResult1));
				//tempResult.clear();
				found = true;
				l1 ++;
				r2 --;
			}
			
			else if(num1.get(l1)[1] + num2.get(r2)[1] < target) {
				
				if(found == false && num1.get(l1)[1] + num2.get(r2)[1] > temp) {
				//	System.out.println("hitting"+ result);
					result.clear();
					temp = num1.get(l1)[1] + num2.get(r2)[1];
					result.add(num1.get(l1)[0]);
					result.add(num2.get(r2)[0]);
					//System.out.println("hitting"+ result);
				}
				else if(found == false && num1.get(l1)[1] + num2.get(r2)[1] == temp) {
				//	System.out.println("hitting"+ result);
					//temp = num1.get(l1)[1] + num2.get(r2)[1];
					result.add(num1.get(l1)[0]);
					result.add(num2.get(r2)[0]);
				}
				l1 ++;
			}
			
			else {
				
				r2 --;
			}
		}
		
		if(found == false) {
		//	System.out.println("hitting"+ result);
			for(int i = 0; i < result.size(); i = i + 2) {
				
				List<Integer> tempResult = new ArrayList<>();
				tempResult.add(result.get(i));
				tempResult.add(result.get(i+1));
			//	System.out.println("hitting"+ tempResult);
				result1.add(new ArrayList<Integer> (tempResult));
			}
		}
		System.out.println("Output: " + result1);
		return result1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<int[]> listA = new ArrayList<>();
        List<int[]> listB = new ArrayList<>();
        listA.add(new int[] {1, 7});
        listA.add(new int[] {2, 14});
        listA.add(new int[] {3, 7});
        listA.add(new int[] {4, 10});
        listB.add(new int[] {1, 8});
        listB.add(new int[] {2, 11});
        listB.add(new int[] {3, 12});
        listB.add(new int[] {4, 5});
        
       // System.out.println("a = " + listA);
      //  System.out.println("b = " + listB);
        int target = 20;
      //  System.out.println("target = " + target);
        calculateCloseElement(listA, listB, target);

	}

}
