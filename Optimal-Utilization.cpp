//Time - O(max(m,n)log(max(m,n))
//Space - O(1)
class Solution{
public:
	vector<pair<int,int>> getIds(vector<pair<int,int>> a, vector<pair<int,int>> b, int target){

		vector<pair<int,int>> ret;

		if(a.size() == 0 || b.size() ==0) return ret;

		vector<pair<int,int>> small = a;
		vector<pair<int,int>> large = b;
		if(a.size()>b.size()) {
			large = a;
			small = b;
		}

		sort(large.begin(),large.end(),[](const pair<int,int>& x, const pair<int,int>& y){
			return x.second<y.second;
		});

		sort(small.begin(),small.end(),[](const pair<int,int>& x, const pair<int,int>& y){
			return x.second<y.second;
		});


		int minDiff = INT_MAX;
		for(int i = 0;i<small.size();i++){
			int idx = binarySearch(large, target-small[i].second);
			if(idx == -1) continue;

			int newDiff = target-(small[i].second + large[idx].second);

			if(newDiff>=0 && newDiff <= minDiff){
				if(newDiff<minDiff){
					minDiff = newDiff;
					ret.erase();
				}
				ret.push_back(make_pair(small[i].first,large[idx].first));
				int index = idx+1;
				while(index<large.size() && large[index].second == large[idx].second){
					ret.push_back(make_pair(small[i].first,large[index++].first));
				}
			}

		}
		return ret;

	}


	int binarySearch(vector<pair<int,int>>& arr, int ele){
		int l = 0, h = arr.size()-1;
		int ans = -1;
		while(l<=r){
			int m = l+(r-l)/2;

			if(arr[m].second == ele){
				int left = m;
				while(left >0 && arr[m].second == arr[left-1]) left--;
				return left;
			}else if(arr[m].second < ele){
				ans = m;
				l = m+1;
			}else{
				r = m-1;
			}
		}
		return ans;
	}
};
