// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we need to find our first occurence of satisfying the condition arr[i]>= n-i.
// we check the same condition using binary search and proceed accordingly.

class Solution {
public:
    int hIndex(vector<int>& arr) {
        int n = arr.size();
        int lo = 0,hi = n-1;
        int ans = 0;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(arr[mid]+mid >=n){
                ans = n - mid;
                hi = mid-1;
            }
            else
            {
                lo = mid +1;
            }
        }
        return ans;
    }
};