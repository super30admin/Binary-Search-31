"""
TC:
  • binarySearch: O(log R + D)  
      - Binary search over returnRoutes takes O(log R).  
      - Collecting duplicates around the matched index costs O(D), where D is the count of duplicates.
  • optimizedRoutes: O(F · (log R + D))  
      - For each forward route, we run binarySearch.  
      - Total work depends on number of forward routes (F) and duplicates scanned per match.

SC: O(1)  
    - We use constant extra space aside from the output.  
    - Sorting returnRoutes occurs in-place.

Approach:
We are given forward route distances, return route distances, and a maximum travel limit.  
Our goal is to find **all forward–return route pairs** whose total distance is:
    1. ≤ maxTravelDist
    2. As large as possible among all feasible pairs
This is a classical “optimized pairing under a constraint” problem.

Key idea:
Instead of brute-forcing all O(F·R) combinations, we sort returnRoutes by distance and binary-search  
for the *best possible matching* return route for each forward route.

Steps:
1. Sort returnRoutes by their travel distance so binary search can operate on the second field.
2. For each [fwd_id, fwd_dist]:
       - Skip if forward distance alone already exceeds the budget.
       - Skip if even the smallest return route is too large.
3. Use binarySearch to find:
       - All return routes whose distance gives the **maximum possible total ≤ maxTravelDist**.
       - Exact matches are preferred; if none found, we return all duplicates of the largest feasible distance.
4. For each match:
       - Compute total = fwd_dist + return_dist.
       - Maintain the globally best total:
             - If total > curr_max → reset answer list.
             - If total == curr_max → append this pair.
5. Return all optimal route pairs.

This binary-search–based strategy avoids nested loops and ensures high efficiency while correctly handling duplicates.

This problem ran successfully on custom test cases.
"""


class Solution:
  
  def binarySearch(self, returnRoutes:List[List[int]], maxTravelDist: int, fwd_dist: int)->List[List[int]]:
    #returns list of [dist, return_id] pairs (to handle duplicates)
    low, high = 0, len(returnRoutes) - 1
    target = maxTravelDist - fwd_dist
    
    while low <= high:
      mid = low + (high - low) // 2
      
      if returnRoutes[mid][1] == target:
        # EXACT MATCH → collect all duplicates
        res = []
        
        # scan left
        i = mid
        while i >= 0 and returnRoutes[i][1] == target:
          res.append([returnRoutes[i][1], returnRoutes[i][0]])
          i -= 1
        
        # scan right
        i = mid + 1
        while i < len(returnRoutes) and returnRoutes[i][1] == target:
          res.append([returnRoutes[i][1], returnRoutes[i][0]])
          i += 1
        
        return res
      
      elif returnRoutes[mid][1] > target:
        high = mid - 1
      else:
        low = mid + 1
    
    # no exact match → use high as best possible
    if high < 0:
      return []
    
    best_dist = returnRoutes[high][1]

    # collect all duplicates with same best_dist
    res = []
    i = high
    while i >= 0 and returnRoutes[i][1] == best_dist:
      res.append([returnRoutes[i][1], returnRoutes[i][0]])
      i -= 1
    
    return res
  
  
  def optimizedRoutes(self, fwdRoutes: List[List[int]], returnRoutes: List[List[int]], maxTravelDist: int)->List[List[int]]:
    curr_max = float('-inf')
    result = []
    
    # sort by return distance
    returnRoutes.sort(key=lambda x: x[1])
    
    for fwd_id, fwd_dist in fwdRoutes:
      
      if fwd_dist > maxTravelDist:
        continue
      
      if maxTravelDist - fwd_dist < returnRoutes[0][1]:
        continue
      
      matches = self.binarySearch(returnRoutes, maxTravelDist, fwd_dist)
      if not matches:
        continue
      
      for dist, return_id in matches:
        total = fwd_dist + dist
        
        if total >= curr_max:
          if total > curr_max:
            result = []  # reset
            curr_max = total
          
          result.append([fwd_id, return_id])
    
    return result

  
sol = Solution()

maxTravelDist = 7000
fwdRoutes = [[1,1000], [2,2000], [3,3000]]
returnRoutes = [[5,3500], [6,3500], [7,1000]]

print(sol.optimizedRoutes(fwdRoutes, returnRoutes, maxTravelDist))