#include <vector>
#include <iostream>
using namespace std;
class Solution {
    public:
        int hIndex(vector<int>& citations) {
            int n = citations.size(), l = 0, h = n-1;
            while(l<h){
                int m = (l+h)/2;
                if(citations[m]>=n-m){
                    h = m;
                }
                else l = m+1;
            }
            return (citations[l]>=n-l)?n-l:0;
    }
};
int main() {
    Solution solution;
    vector<int> citations = {0,1,3,5,6};
    int result = solution.hIndex(citations);
    cout << "H-Index: " << result << endl; // Output: 3
    return 0;
}
// // Time Complexity: O(log n) where n is the number of elements in the citations array
// // Space Complexity: O(1)
// // Did this code successfully run on Leetcode: Yes
// // Any problem you faced while coding this: No
// // Your code here along with comments explaining your approach in three sentences only
// Used binary search to find leftmost index such that citations[index]>=n-index, because the numbers from that index to the end will be at least n-index and if this condition is satisfied, all of them would be atleast n-index.