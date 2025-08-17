/*
Time Complexity: O(log(n)), n is the number of total citations
Space Complexity: O(1)
Run on leetcode: yes
Any Difficulties: Yes, to understand the problem, it required a lot of effort :(
Approach:
Solved after discussed in the class- Binary Search
 */
public class HIndexII {
    public static int hIndexII(int[] citations){
        int start = 0;
        int end = citations.length-1;

        int totalNumberOfCitations = citations.length;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(totalNumberOfCitations-mid == citations[mid]){
                return citations[mid];
            }else if(totalNumberOfCitations-mid> citations[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return totalNumberOfCitations-start;
    }

    public static void main(String[] args){
        int[] citations = {0,1,3,5,6};

        System.out.println("H Index: "+ hIndexII(citations));
    }
}
