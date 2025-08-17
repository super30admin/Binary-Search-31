package problems.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TC=O(logn)
//SC=O(1)
public class Problem275 {

    public int hIndex(int[] citations) {
        int low=0;
        int n=citations.length;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int diff=n-mid;
            if(citations[mid]==diff)
                return diff;
            else if(citations[mid]>diff)
                high=mid-1;
            else
                low=mid+1;
        }

        return n-low;
    }

    public static void main(String[] args) {
        Problem275 problem=new Problem275();
        System.out.println(problem.hIndex(new int[]{0,1,3,5,6}));
        System.out.println(problem.hIndex(new int[]{1,2,100}));
    }
}
