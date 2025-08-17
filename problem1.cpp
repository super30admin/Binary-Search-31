// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

#include<iostream>
#include<vector>

using namespace std;

class Solution{
    
    public:
    void display(vector<vector<int>>& arr1){
        cout<<"loc 1"<<"loc 2"<<"dist "<<endl;
        for(auto c:arr1){
            cout<<c.at(0)<<" "<<c.at(1)<<endl;
        }
    }
    vector<vector<int>> max_routes(vector<vector<int>>& arr1,vector<vector<int>>& arr2,int target){
        int m = arr1.size();
        int n = arr2.size();
        sort(arr1.begin(),arr1.end(),[](vector<int>& arr1,vector<int>& arr2){return arr1.at(1)<arr2.at(1);});
        sort(arr2.begin(),arr2.end(),[](vector<int>& arr1,vector<int>& arr2){return arr1.at(1)<arr2.at(1);});
        int i{},j{n-1};
        int max_dist{-1};
        unordered_map<int,vector<vector<int>>> res{};
        while(i<m && j>=0){
            int u_val = arr1.at(i).at(1);
            int d_val = arr2.at(j).at(1);
            int u_id = arr1.at(i).at(0);
            int d_id = arr2.at(j).at(0);
            int sum = u_val + d_val;
            if(sum <= target){
                
                if(sum>=max_dist){
                    max_dist = sum;
                    if(res.find(max_dist) == res.end()){
                        res[max_dist] = vector<vector<int>>{};
                    }
                    res[max_dist].push_back(vector<int>{
                        u_id,d_id
                    });
                }
            }
                
            if(u_val<d_val){
                j--;
            }
            else{
                i++;
            }
        }
    return res[max_dist];
    }  
};

int main(){
    vector<vector<int>> arr1{
        {1,1000},
        {2,1000},
        {3,2000},
        {4,3000},
        {5,6000},
        {6,9000}
    };
    vector<vector<int>> arr2{
        {1,2000},
        {2,3000},
        {3,5000},
        {4,6000},
        {5,6000},
        {6,7000},
        {7,8000}
    };
    int target{7500};
    Solution solve;
    vector<vector<int>> res = solve.max_routes(arr1,arr2,target);
    solve.display(res);
}