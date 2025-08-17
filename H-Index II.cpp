//Time Complexity- O(log(n))
//Space Complexity- O(1)

class Solution {
public:
    int hIndex(vector<int>& citations) {
                
        if(citations.size()==0){
            return 0;
        }
        
        if(citations[0]>=citations.size()){
            return citations.size();
        }
        
        int high=citations.size()-1;
        int low=0;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(citations[mid]==citations.size()-mid){
                return citations[mid];
            }
            else if(citations[mid]>citations.size()-mid){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return citations.size()-low;
    }
};