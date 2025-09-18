#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use binary search to check if the number of citations is maximum on the left
or right, we take a count variable which will store the max value
and then simply we return count;
*/
class Solution{
public:
    int hIndex(vector<int>& citations){
        int n = citations.size();
        int low=0, high=n-1;
        int count = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(citations[mid] < n - mid){
                low = mid+1;
            }else{
                count = max(count, n-mid);
                high = mid-1;
            }
        }
        return count;
    }
};
