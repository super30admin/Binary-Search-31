class Solution {

    // Binary search to find idx of element as close to (but not greater than) target
    public int search(int target, List<Integer> list){

        if(list.isEmpty()) return -1;

        // Find index of element <= target
        int low = 0;
        int high = list.size()-1;
        int mid;

        while(low <= high){
            mid = low + (high-low)/2;
            int num = list.get(mid);
            if(num < target){
                if(mid < list.size()-1){
                    // there is another element to the right
                    int next = list.get(mid+1);
                    if(next > target){
                        return mid;
                    } else {
                        low = mid+1;
                        continue;
                    }
                } else {
                    // there is no element to the right and num is smaller
                    return mid;
                }
            } else if (num == target){
                return mid;
            } else {
                high = mid-1;
            }
        }

        return -1;
    }

    private void insert(int element, ArrayList<Integer> list){
        if(list.size() == 0){
            list.add(element);
            return;
        }

        // first find index of element just less than or equal to target
        int idx = search(element, list);
        //System.out.println("Insert idx: " + idx);
        if(idx == -1){
            list.add(0, element);
        } else list.add(idx+1, element);
        return;
    }

    public int twoSumLessThanK(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = -1;
        for(int i = nums.length-1; i > -1; i--){
            int num = nums[i];
            int complement = k - num;
            int idx = search(complement-1, list);
            if(idx != -1) {
                sum = Math.max(sum, Math.min(num + list.get(idx), k-1));
            }
            insert(num, list);
            //System.out.println("num: " + num + ", complement: " + complement + ", sum: " + sum + ", idx: " + idx);
            //System.out.println(list);
        }
        return sum;
    }
}
