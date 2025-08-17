# Solution

# // Time Complexity : O(LOGN) and O(N) two solutions available
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : Yes 
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Basically we need to find number of papers whose citations are greater than or equal to number of papers.
# O(logN) approach: Almost similar to below approah, only thing is we use binary search and perform the same check, but
# even if we find something, we need to remeber that there can be more papers so move the high to left side. At some point
# high crosses low and gives n-low number of papers for citations
# O(N) approach: At any index i you can find number of papers(n-i) where n is len of array whose citations >= citations[i]
# But we need number of citations >= number of papers. So we need to check that in linear order to find the result

def hIndex(citations):
    # O(logn) solution
    n = len(citations)
    low = 0
    high = n-1

    while low<=high:
        mid = low+((high-low)//2)

        if citations[mid]>=n-mid:
            high = mid-1
        else:
            low = mid+1
    
    return n-low
    # O(n) solution
    # n = len(citations)

    # for citation in citations:
    #     if n<=citation:
    #         return n
    #     else:
    #         n -= 1
    
    # return 0

if __name__ == "__main__":
    citations = [0,1,2,5,6]
    print(hIndex(citations))