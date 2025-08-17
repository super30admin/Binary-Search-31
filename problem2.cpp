// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*

iterate over the array and decrease the size of the array , 
when you find the value of citation greater than equal to that of size of the array give the result

*/

#include<iostream>
#include<vector>
#include<queue>

using namespace std;

// single iteratoin solution

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int res;
        for(size_t i{},j{citations.size()};i<citations.size();++i,--j){
            if(citations.at(i)>=j){
                res = j;
                break;
            }
        }
        return res;
    }
};

// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*

Find the middle pointer , check if the citations is greater than the h_val at that position 
also check if the previous value is also less than equal to the number of citations
if both satisfy return result , if the first only satisfy then shift the high to mid;
IF both dont satisfy shift low to mid+1;

*/

// binary search solution

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        int low{0};
        int high{n-1};
        int res{};
        if(low == high){
            if(citations.at(0)>0) return 1;
            else return 0;
        }
        while(low<=high){
            int mid = low + (high - low)/2;
            int h_val = n - mid;
            // condition of equality or to move high pointer
            if(citations.at(mid)>=h_val){
                if(mid == 0){
                    res = h_val;
                    break;
                }
                else{
                    if(citations.at(mid-1)<=h_val){
                        res = h_val;
                        break;
                    }
                    high = mid;
                }
            }
            //condition to move low pointer
            else{
                low = mid+1;
            }

        }
        return res;
    }
};