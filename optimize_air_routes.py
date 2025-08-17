# two-pointers
# TC: O(m+n); SC: O(1)
class Solution:
    def optimizeAirRoutes(self, front, back, capacity):
        if len(front) > len(back):
            return self.optimizeAirRoutes(back, front, capacity)
        result = []
        max = 0
        start = 0
        end = len(back) - 1
        while start < len(front) and end >= 0:
            if capacity >= front[start][1] + back[end][1] > max:
                result = [(front[start][0], back[end][0])]
                max = front[start][1] + back[end][1]
            elif capacity >= front[start][1] + back[end][1] == max:
                result.append((front[start][0], back[end][0]))
            if front[start][1] + back[end][1] < capacity:
                start += 1
            else:
                end -= 1
        return result


front = [(0, 1000), (1, 1500), (2, 2000), (3, 3000), (4, 4500), (5, 6000)]
back = [(0, 1500), (1, 2500), (2, 3000), (3, 3500), (4, 4000), (5, 5000)]
print(Solution().optimizeAirRoutes(front, back, 7200))


# Using Binary Search
# TC: O(m*log(n)) m -> length of smaller array, n -> length of bigger array;
# SC: O(1)
# class Solution:
#     def findClosest(self, back, target):
#         start = 0
#         end = len(back)-1
#         while start <= end:
#             mid = start + (end-start)//2
#             if back[mid][1] == target:
#                 return back[mid]
#             elif back[mid][1] < target:
#                 start = mid + 1
#             else:
#                 end = mid - 1
#         if start < len(back) and abs(back[start][1]-target) < abs(back[end][1]-target):
#             return back[start]
#         else:
#             return back[end]
#
#     def optimizeAirRoutes(self, front, back, capacity):
#         if len(front) > len(back):
#             return self.optimizeAirRoutes(back, front, capacity)
#         result = []
#         max = 0
#         for i in front:
#             target = capacity - i[1]
#             pair = self.findClosest(back, target)
#             if capacity >= pair[1] + i[1] > max:
#                 result = [(i[0], pair[0])]
#                 max = pair[1] + i[1]
#             elif capacity >= pair[1] + i[1] == max:
#                 result.append((i[0], pair[0]))
#         return result
#
#
# front = [(0, 1000), (1, 1500), (2, 2000), (3, 3000), (4, 4500), (5, 6000)]
# back = [(0, 1500), (1, 2500), (2, 3000), (3, 3500), (4, 4000), (5, 5000), (6, 6000)]
# print(Solution().optimizeAirRoutes(front, back, 7200))


# Brute-force
# TC: O(m*n); SC: O(1)
# class Solution:
#     def optimizeAirRoutes(self, front, back, capacity):
#         result = []
#         max = 0
#         for i in front:
#             for j in back:
#                 if capacity >= i[1] + j[1] > max:
#                     result = [(i[0], j[0])]
#                     max = i[1] + j[1]
#                 elif capacity >= i[1] + j[1] == max:
#                     result.append((i[0], j[0]))
#         return result
#
#
# front = [(0, 1000), (1, 1500), (2, 2000), (3, 3000), (4, 4500), (5, 6000)]
# back = [(0, 1500), (1, 2500), (2, 3000), (3, 3500), (4, 4000), (5, 5000), (6, 6000)]
# print(Solution().optimizeAirRoutes(front, back, 7200))
