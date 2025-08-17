//Time - O(n) n-size of citations arr
//Space - O(1)

class Solution {
public:
    int hIndex(vector<int>& citations) {
        int N = citations.size();
        int l = 0, h = N-1;
        
        
        while(l<=h){
            int m = l + (h-l)/2; 
            if(citations[m] == N-m){
                return N-m;
            }else if(citations[m]<N-m){
                l = m+1;
            }else{
                h = m-1;
            }
        }
        
        return N-l;
    }
};