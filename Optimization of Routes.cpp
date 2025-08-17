//Time Complexity- O(nlog(n)+mlog(m))
//Space Complexity- O(1)

int helper(vector<pair<int,int>> &arr1,vector<pair<int,int>> &arr2,int target){

    sort(arr1.begin(),arr1.end());
    sort(arr2.begin(),arr2.end());

    int ptr1=0;
    int ptr2=arr2.size()-1;

    vector<pair<int,int>> ans;
    int sum=INT_MIN;

    while(ptr1<arr1.size() && ptr2>=0){

        int currSum=arr1[ptr1].second+arr2[ptr2].second;
        if(currSum<=target){
            if(currSum>sum){
                ans.clear();
                sum=currSum;
            }
            ans.push_back({arr1[ptr1].first,arr2[ptr2].first});
            ptr1++;
        }
        else{
            ptr2--;
        }
    }
}


int main(){

    vector<pair<int,int>> arr1 = { {1, 2000}, {2, 3000}, {3, 4000} };
    vector<pair<int,int>> arr2 = { { 1, 5000 }, {2, 3000} };
    int target=5000;
    int ans=helper(arr1,arr2,target);
    cout<<ans<<endl;
    return 0;
}