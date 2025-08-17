/*
 * Time Complexity: O(length of smaller array)
 * Space Complexity: O(n)
 * Did this code run successfully on LeetCode: yes
 * Approach: we are iterating over the smaller array and creating a HashMap for it. Then, we iterate over 
 * the larger array and check if the element is present in the HashMap
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Intersection {
    //approach 1
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2,nums1);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        List<Integer> li = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num,map.get(num)-1);
                map.remove(num,0);
            }
        }
        
        int result[] = new int[li.size()];
        for(int i = 0; i<li.size();i++)
        {
            result[i] = li.get(i);
        }
        return result;
    }

    //Using Two pointer approach - if equal then add and increment both the pointers, if less move the 1st pointer, if more move the 
    //second pointer
    //Approach 2: Two pointers
    public static int[] usingBS(int nums1[],int nums2[]){
        if(nums1.length > nums2.length)
            return usingBS(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int p1=0,p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                li.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }
        int result[] = new int[li.size()];
        for(int i = 0; i<li.size();i++)
        {
            result[i] = li.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        int[] result1 = intersect(nums1, nums2);

        for(int i = 0; i< result1.length;i++)
        {
            System.out.println(result1[i]);
        }

        System.out.println("***************Approach 2*********************");
        int[] result2 = usingBS(nums1, nums2);

        for(int i = 0; i< result2.length;i++)
        {
            System.out.println(result2[i]);
        }
    }
}
