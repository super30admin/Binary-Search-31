/*
# O(n) - tc
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        
        n = len(citations)
        for i in range(n):
            diff = n - i
            if diff <= citations[i]:
                return diff
        
        return 0
*/

/*
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        for (int i=0; i<n; i++){
            int diff = n - i;
            if (diff <= citations[i])
                return diff;
        }
        return 0;
    }
}
*/

/*

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        
        return self.binary(citations, 0, len(citations)-1)
    
    def binary(self, citations, start, end):
        n = len(citations)
        
        while start <= end:
            mid = start + (end-start)//2
            
            if citations[mid] == n-mid:
                return n - mid
                
            elif citations[mid] >= n-mid:
                end = mid - 1
                
            else:
                start = mid + 1
        return n - start
*/

// Time Complexity : O(logn)
// Space Complexity : O(1)

// Your code here along with comments explaining your approach: Used binary search to find the right citation

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        
        return binary(citations, 0, citations.length-1);
    }
    private int binary(int[] citations, int start, int end){
        int n = citations.length;
        
        while (start <= end){
            int mid = start + (end-start)/2;
            
            if (citations[mid] == n - mid)
                return n - mid;
            
            else if (citations[mid] > n - mid)
                end = mid - 1;
            
            else
                start = mid + 1;
                
        }
        return n - start;
    }
}