# Time Complexity : O(nlog(n) + mlog(m)) + O(n)
# Space Complexity : O(1)

# Given two lists of pairs, find the pair of pairs such that the sum of their second elements is less than or equal to a target value and as close to the target value as possible.

# Approach:
# 1. Sort both lists based on the second element of the pairs.
# 2. Use two pointers to find the optimal pairs.
# 3. Initialize a variable to keep track of the maximum sum found so far.
# Initialize 1 pointer to the start of the first list and the other pointer to the end of the second list.
# 4. Iterate through the lists until one of the pointers goes out of bounds.
# 5. Calculate the sum of the second elements of the pairs at the current pointers.
# Update the sum and the result list if the current sum is less than or equal to the target and greater than the maximum sum found so far.
class Solution(object):
    def optimal_utilization(self, a, b, target):
        # Sort both lists based on the second element of the pairs
        sortA = sorted(a, key=lambda x: x[1])
        sortB = sorted(b, key=lambda x: x[1])
        # Initialize 2 pointers
        # 1 pointer to the start of the first list and the other pointer to the end of the second list
        l, r = 0, len(sortB)-1
        # Initialize result list and maximum sum found so far
        res = []
        dist = float("-inf")
        # Iterate through the lists until one of the pointers goes out of bounds
        while l < len(sortA) and r >= 0:
            # Calculate the sum of the second elements of the pairs at the current pointers
            currDist = sortA[l][1] + sortB[r][1]
            # If the current sum is less than or equal to the target, it is a candidate for the result
            if currDist <= target:
                # Check if the current sum is greater than the maximum sum found so far
                if currDist > dist:
                    # If it is, update the result list and the maximum sum
                    # Remove the last element from the result list if it is not empty
                    # This is done to ensure that we only keep the closest pairs
                    if len(res) != 0:
                        res.pop()
                    dist = currDist
                    # Add the current pair to the result list
                    res.append([sortA[l][0],sortB[r][0]])
                    # If the current sum is less than the target, move the left pointer to the right
                    if currDist < target:
                        l += 1
                    # If the current sum is greater than the target, move the right pointer to the left
                    else:
                        r -= 1
                
                else:
                    # If the current sum is equal to the maximum sum found so far, add the current pair to the result list
                    if currDist == dist:
                        res.append([sortA[l][0],sortB[r][0]])
                    # If the current sum is less than the target, move the left pointer to the right
                    if currDist < target:
                        l += 1
                    # If the current sum is greater than the target, move the right pointer to the left
                    else:
                        r -= 1
            # If the current sum is greater than the target, move the right pointer to the left
            if currDist > target:
                r -= 1
        # Return the result list
        # The result list contains the pairs of pairs such that the sum of their second elements is less than or equal to the target value
        # and as close to the target value as possible
        return res
        

a = [[1, 8], [2, 7], [3, 14]]
b = [[1, 5], [2, 10], [3, 14]]
target = 20
solution = Solution()
print(solution.optimal_utilization(a, b, target))