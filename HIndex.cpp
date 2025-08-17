//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;


class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n=citations.size();
        int mid;
        int low=0;
        int high=n-1;
        while(high>=low)
        {
            mid = low + (high-low)/2;
            int midElement=citations[mid];
            int midMore=n-mid;
            
            if(midElement==midMore)
            {
                return midMore;
            }
            else if(midElement>midMore)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
            
        }
        return n-low;
    }
};