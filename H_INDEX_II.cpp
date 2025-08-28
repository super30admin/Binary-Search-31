//Time Complexity:O(logn)
//Space Complexity:O(1)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        int low = 0,high = n-1;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(citations[mid] < n-mid) low = mid + 1;
            else if(citations[mid] >= n-mid){
                ans = n-mid;
                high = mid - 1;
            }
        }
        return ans;
    }
};