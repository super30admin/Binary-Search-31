# Time Complexity : O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : No

def primeAir(arr1, arr2, target):
    closest = -1
    result = []
    for id1, val1 in arr1:
        for id2, val2 in arr2:
            s = val1 + val2
            if s > target:
                continue
            if s > closest:
                closest = s
                result = [[id1, id2]]
            elif s == closest:
                result.append([id1, id2])
    return result