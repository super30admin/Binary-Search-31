#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We sort the backward flights first so we can look them up fast.
For each forward flight, we binary-search the biggest backward leg that still keeps us under the target.
We track the best total distance so far and store every pair that matches that best.
*/
class Solution {
public:
    vector<vector<int>> optimalAirRoute(vector<vector<int>>& forward,
                                        vector<vector<int>>& backward,
                                        int target) {
        sort(backward.begin(), backward.end(),
             [](const vector<int>& a, const vector<int>& b) { return a[1] < b[1]; });

        vector<vector<int>> result;
        int maxVal = 0;

        for (auto& f : forward) {
            int index = binarySearch(backward, target - f[1]);
            if (index != -1) {
                int sumVal = f[1] + backward[index][1];
                if (sumVal >= maxVal) {
                    if (sumVal > maxVal) {
                        result.clear();
                    }
                    maxVal = sumVal;
                    result.push_back({f[0], backward[index][0]});
                }
            }
        }
        return result;
    }

private:
    int binarySearch(const vector<vector<int>>& backward, int target) {
        int low = 0, high = (int)backward.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (backward[mid][1] == target) return mid;
            else if (backward[mid][1] < target) low = mid + 1;
            else high = mid - 1;
        }
        return high; // largest ≤ target or -1
    }
};
