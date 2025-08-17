/*
method 1 - use hashmap to store the freq of elements in shorter array
then traverse the larger array and record the common elements

time complexity : O(n+m)
space complexity :O(m)


method 2 - follow up
what if arrays are sorted?

use pointer approach to sovle the problem.
keep p1 = 0 of nums1
keep p2 = 0 of nums2
and iterate both arrays

time complexity:O(n+m)
space complexity:O(1)

method 3: binary Search
time complexity: O(log n)

*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums2.length < nums1.length){
            return intersect(nums2, nums1);
        }
              
//         HashMap<Integer,Integer> freqmap = new HashMap<>();
//         for(int i : nums1){
//             if(!freqmap.containsKey(i)){
//                 freqmap.put(i,1);
//             }
//             else{
//                 freqmap.put(i,freqmap.get(i)+1);
//             }
//         }
        
//         List<Integer> result = new ArrayList<>();
//         for(int i = 0; i < nums2.length;i++){
//             if(freqmap.containsKey(nums2[i])){
//                 result.add(nums2[i]);
//                 int val = freqmap.get(nums2[i]);
//                 val = val-1;
//                 if(val == 0){
//                     freqmap.remove(nums2[i]);
//                 }else{
//                     freqmap.put(nums2[i],val);
//                 }
//             }
//         }
        
//         
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // int p1 = 0;
        // int p2 = 0;
        
        List<Integer>list = new ArrayList<>();
        
        // while(p1 < nums1.length && p2 < nums2.length){
        //     if(nums1[p1] == nums2[p2]){
        //         list.add(nums1[p1]);p1++;p2++;
        //     }
        //     else if (nums1[p1] < nums2[p2]){
        //         p1++;
        //     }else{
        //         p2++;
        //     }
        // }
        
        
        int low = 0;
        int high = nums2.length-1;
        for(int i = 0; i < nums1.length;i++){
            int bsIndex = BinarySearch(nums2,nums1[i],low,high);
            if(bsIndex != -1){
                list.add(nums1[i]);
                low = bsIndex+1;
            }
        }
        
        int[]ans = new int[list.size()];
        for(int i = 0;i < ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    private int BinarySearch(int[]nums,int target, int low, int high){
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1; //keep moving left until find first index, to eliminate duplicates
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
            
                
        }
        return -1;
    }
}