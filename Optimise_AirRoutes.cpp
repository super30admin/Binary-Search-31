// Time Complexity: O(n log m + m log m)
// Space Complexity: O(1)
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int>> optAirRoute(vector<vector<int>>& fwd,vector<vector<int>>& bwd,int tgt) {
        sort(bwd.begin(), bwd.end(),[](const vector<int>& a, const vector<int>& b) { return a[1] < b[1]; });
        vector<vector<int>> res;
        int maxSum = 0;
        for (auto& f : fwd) {
            int idx = bs(bwd, tgt - f[1]);
            if (idx != -1) {
                int sum = f[1] + bwd[idx][1];
                if (sum >= maxSum) {
                    if (sum > maxSum) res.clear();
                    maxSum = sum;
                    res.push_back({f[0], bwd[idx][0]});
                }
            }
        }
        return res;
    }
    int bs(const vector<vector<int>>& bwd, int tgt) {
        int lo = 0, hi = (int)bwd.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (bwd[mid][1] == tgt) return mid;
            else if (bwd[mid][1] < tgt) lo = mid + 1;
            else hi = mid - 1;
        }
        return hi;
    }
};
