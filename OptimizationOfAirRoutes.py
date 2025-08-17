from typing import List

# def closest_pairs(arr1: List[List[int]], arr2: List[List[int]], target: int) -> List[List[int]]:
#     # Step 1: Sort both arrays based on the values (2nd element)
#     arr1.sort(key=lambda x: x[1])
#     arr2.sort(key=lambda x: x[1])
    
#     res = []
#     max_sum = float('-inf')

#     # Extract values from arr2 for binary search
#     values2 = [val for _, val in arr2]

#     for id1, val1 in arr1:
#         remain = target - val1

#         # Binary search to find best match in arr2
#         l, r = 0, len(arr2) - 1
#         best_idx = -1
#         while l <= r:
#             mid = (l + r) // 2
#             if arr2[mid][1] <= remain:
#                 best_idx = mid
#                 l = mid + 1
#             else:
#                 r = mid - 1
        
#         if best_idx != -1:
#             val2 = arr2[best_idx][1]
#             pair_sum = val1 + val2
#             if pair_sum > max_sum:
#                 max_sum = pair_sum
#                 res = [[id1, arr2[best_idx][0]]]
#             elif pair_sum == max_sum:
#                 res.append([id1, arr2[best_idx][0]])
    
#     return res


def closest_pairs(arr1: List[List[int]], arr2: List[List[int]], target: int) -> List[List[int]]:
    # Sort both arrays by their values
    arr1.sort(key=lambda x: x[1])
    arr2.sort(key=lambda x: x[1])
    
    i, j = 0, len(arr2) - 1
    max_sum = float('-inf')
    res = []

    while i < len(arr1) and j >= 0:
        val1 = arr1[i][1]
        val2 = arr2[j][1]
        total = val1 + val2

        if total > target:
            j -= 1  # Decrease sum
        else:
            if total > max_sum:
                max_sum = total
                res = [[arr1[i][0], arr2[j][0]]]
            elif total == max_sum:
                res.append([arr1[i][0], arr2[j][0]])
            
            # There may be other `arr2` entries with the same value2 — scan left
            k = j - 1
            while k >= 0 and arr2[k][1] == val2:
                if val1 + arr2[k][1] == max_sum:
                    res.append([arr1[i][0], arr2[k][0]])
                k -= 1

            i += 1  # Try next val1

    return res
