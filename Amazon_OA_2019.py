# Description
# Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that
# the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.

# Example 1:

# Input:
# a = [[1, 2], [2, 4], [3, 6]]
# b = [[1, 2]]
# target = 7

# Output: [[2, 1]]

# Explanation:
# There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
# Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
# Example 2:

# Input:
# a = [[1, 3], [2, 5], [3, 7], [4, 10]]
# b = [[1, 2], [2, 3], [3, 4], [4, 5]]
# target = 10

# Output: [[2, 4], [3, 2]]

# Explanation:
# There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
# Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
# These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
# Example 3:

# Input:
# a = [[1, 8], [2, 7], [3, 14]]
# b = [[1, 5], [2, 10], [3, 14]]
# target = 20

# Output: [[3, 1]]
# Example 4:

# Input:
# a = [[1, 8], [2, 15], [3, 9]]
# b = [[1, 8], [2, 11], [3, 12]]
# target = 20

# Output: [[1, 3], [3, 2]]

# Solution

# // Time Complexity : O(m+n) where m is length of a and n is length of b
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Not Applicable
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to sort the input lists with the distances and then use the two pointer approach. Start one pointer from the end and the other point from the begining of the other array. Now the if the sum is greater than target
# then reduce the pointer of the higher value and continue. If obtained value is less than target, then increase the pointer of lesser array and proceed.
import math
def solution(a,b,target):
    n1 = len(a)
    n2 = len(b)

    a.sort(key = lambda x:x[1])
    b.sort(key = lambda x:x[1])

    low = 0
    high = n2-1
    result = []

    temp = -math.inf
    while low<n1 and high>=0:

        curr = a[low][1] + b[high][1]

        if curr<target:
            if curr>temp:
                if result:
                    result.pop()
                result.append([a[low][0],b[high][0]])
            elif curr == temp:
                result.append([a[low][0],b[high][0]])
            low += 1
            if temp<curr:
                temp = curr
        elif curr>target:
            high -= 1
        else:
            if curr>temp:
                if result:
                    result.pop()
                result.append([a[low][0],b[high][0]])
            elif curr == temp:
                result.append([a[low][0],b[high][0]])
            high -= 1
            if temp<curr:
                temp = curr
    
    return result



if __name__ == "__main__":
    # a = [[1, 3], [2, 5], [3, 7], [4, 10]]
    # b = [[1, 2], [2, 3], [3, 4], [4, 5]]
    # target = 10  
    # a = [[1, 2], [2, 4], [3, 6]]
    # b = [[1, 2]]
    # target = 7  
    # a = [[1, 8], [2, 7], [3, 14]]
    # b = [[1, 5], [2, 10], [3, 14]]
    # target = 20
    a = [[1, 8], [2, 15], [3, 9]]
    b = [[1, 8], [2, 11], [3, 12]]
    target = 20
    print(solution(a,b,target))