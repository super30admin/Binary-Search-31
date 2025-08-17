// Time Complexity :O(nlogn) //sort
// Space Complexity : O(1)   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

bool compare(vector<int> a,vector<int> b){
    return a[1] < b[1];
} 
vector<vector<int>> getPairs(vector<vector<int>> a, vector<vector<int>> b, int target){
    sort(a.begin(),a.end(),compare);
    sort(b.begin(),b.end(),compare);
    int left = 0;
    int right = b.size()-1;
    vector<vector<int>> ans;
    int max = INT_MIN;
    int sum = 0;
    while(left < a.size() && right >=0){
        sum = a[left][1] + b[right][1];
        if(sum > target) right--;
        else{
            if(sum > max){
                max = sum;
                ans.clear();
                ans.push_back({a[left][0],b[right][0]});
            }
            else if(sum == max){
                ans.push_back({a[left][0],b[right][0]});
            }
            left++;
        }
    }
    return ans;
}
int main() {
    vector<vector<int>> a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
    vector<vector<int>> b ={{1, 2}, {2, 3}, {3, 4}, {4, 5}};
    int target = 10;
    vector<vector<int>> ans = getPairs(a,b,target);
    for(auto &a:ans){
        cout<<a[0]<<","<<a[1]<<endl;
    }
    return 0;
}