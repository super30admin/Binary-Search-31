# TC : max((NlogN), (MlogM))    where N and M are the size of the given lists
# SC : O(1)
class Solution:
    def findPairs(self, a, b, target):
        # sorting the given forward routes and backward routes wrt distance
        a.sort(key=lambda x: x[1])
        b.sort(key=lambda x: x[1])
        
        # set 2 pointers at start of forward route list and end of backward route list
        l, r = 0, len(b) - 1
        result = []
        
        # variable to keep check of the current difference
        curDiff = float('inf')
        
        # Until we fully traverse through both the lists
        while l < len(a) and r >= 0:
            id1, i = a[l]
            id2, j = b[r]
            if (target - i - j == curDiff):
                result.append([id1, id2])
            elif (i + j <= target and target - i - j < curDiff):
                result=[]
                result.append([id1, id2])
                curDiff = target - i - j
                
            # Move the pointers until we find the optimal routes
            if (target > i + j):
                l += 1
            else:
                r -= 1
                
        return result