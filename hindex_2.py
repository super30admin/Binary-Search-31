'''
275 H-Index II
https://leetcode.com/problems/h-index-ii/description/

Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in non-descending order, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

You must write an algorithm that runs in logarithmic time.


Example 1:
Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

Example 2:
Input: citations = [1,2,100]
Output: 2

Constraints:
n == citations.length
1 <= n <= 105
0 <= citations[i] <= 1000
citations is sorted in ascending order.

Solution:
Formally, if f is an array that corresponds to the number of citations for each publication, we compute the h-index as follows: First we order the values of f from the largest to the lowest value. Then, we look for the last position in which f is greater than or equal to the position (we call h this position).

For example, if we have a researcher with 5 publications A, B, C, D, and E with 10, 8, 5, 4, and 3 citations, respectively, the h-index is equal to 4 because there are 4 publications (A, B, C, D)  with citations 10, 8, 5, 4 (>= 4 citations).

However, if the same researcher has 25, 8, 5, 3, 3 citations, then the h-index is 3 (i.e. the 3rd position) because there are 3 papers (C, D, E) with citations 5, 3, 3 respectively (>= 3 citations)


Formulae for h-index:
1. If f is arranged in decreasing order:
Formula 1:    h-index (f) = max {i+1 ∈ N : f (i) ≥ i+1}
                          = 1 + max {i ∈ N : f (i) ≥ i+1}

2.  If f is arranged in inreasing order:
Formula 2:    h-index (f) = max {N-i, i ∈ N : f (i) ≥ N-i}
                          = N + max {-i, i ∈ N : f (i) ≥ N-i}
                          = N - min {i, i ∈ N : f (i) ≥ N-i}

Example 1:
f =   [6, 5, 3, 1, 0] (decreasing order)
i =   [0, 1, 2, 3, 4]
i+1 = [1, 2, 3, 4, 5]
i   f(i)    i+1     f(i) >= i+1?
0   6       1           T
1   5       2           T
2   3       3           T
3   1       4           F
4   0       5           F
h-index (f) = 1 + max {0,1,2} = 1 + 2 = 3

Example 2:
f =   [10, 8, 5, 4, 3] (decreasing order)
i =   [0,  1, 2, 3, 4]
i+1 = [1,  2, 3, 4, 5]
h-index (f) = 1 + max {0,1,2,3} = 4


Example 3:
f =   [0, 1, 3, 5, 6] (increasing order)
i =   [0, 1, 2, 3, 4]
N-i = [5, 4, 3, 2, 1]
Q to ask is: Find the first i such that f(i) >= N-i
i   f(i)    N-i     f(i) >= N-i?
0   0       5           F
1   1       4           F
2   3       3           T
3   5       2           T
4   6       1           T
h-index (f) = N - min {2,3,4} = 5 - 2 = 3
Thus,
f =   [0,  1,     3,     5,    6]
      --f(i)<N-i- | --f(i)>=N-i--
                h-index

Example 4:
f =   [3, 4, 5, 8, 10] (increasing order)
i =   [0, 1, 2, 3, 4]
N-i = [5, 4, 3, 2, 1]
h-index (f) = N - min {1,2,3,4} = 5 - 1 = 4

1. Linear Search
We apply Formula 2 since the array is sorted in increasing order. Traverse the sorted array from left to right. If the ith element of array is f[i], then we are looking for the first instance when f[i] >= N-i. When that happens, return N-i.
Time: O(N), Space: O(1)
https://youtu.be/2nGcMdebMvU?t=3989

2. Binary Search
We apply Formula 2 since the array is sorted in increasing order. Perform a binary search to search for the first index when f[i] >= N-i. That means, we are searching for i which in binary search is the mid index. When that happens, return N-mid.
Time: O(log N), Space: O(1)
https://youtu.be/2nGcMdebMvU?t=4510
'''

def hIndex_linear(citations):
    '''Time: O(N), Space: O(1)'''
    if not citations:
        return 0

    N = len(citations)
    for i in range(N):
        if citations[i] >= N-i:
            return N-i
    return 0

def hIndex_binary(citations):
    '''Time: O(log N), Space: O(1)'''
    if not citations:
        return 0

    N = len(citations)
    low, high = 0, N-1
    while low <= high:
        mid = low + (high - low)//2
        if citations[mid] == N-mid:
            return N-mid
        elif citations[mid] > N-mid:
            # go lower on mid since lower mid implies higher N-mid
            # which is the same thing as higher h-index
            high = mid - 1
        else:
            # go higher on mid which implies lower h-index
            low = mid + 1
    return N-low


def run_hIndex():
    tests = [([0,1,3,5,6], 3), # exactly hits "if citations[mid] == N-mid"
             ([0,10,20,40], 3), # exits loop because low > mid
             ([1,2,100], 2), # exits loop because low > mid
             ([0,1,4,5,6], 3),
             ([3,4,5,8,10],4),
             ([3,3,5,8,25],3),
             ([0,0,0,0,0], 0), # mid goes out of bounds on the right of array
             ([10,10,10,10,10],5), # mid goes out of bounds on the left of array
    ]
    for test in tests:
        citations, ans = test[0], test[1]
        for method in ['linear', 'binary']:
            if method in 'linear':
                h = hIndex_linear(citations)
            elif method in 'binary':
                h = hIndex_binary(citations)
            print(f"\ncitations = {citations}")
            print(f"{method}: H-index = {h}")
            success = (ans == h)
            print(f"Pass: {success}")
            if not success:
                return

run_hIndex()
