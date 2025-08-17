'''
Solution:
1.  First, sort the least sized array, and then search for a number which is close to the complement of the element
    in the other array.
2.  While traversing, if the sum of two numbers is greater than the existing max value, then create a new list and add
    the pair to the list and otherwise add the pair to the existing list.
Time Complexity: O((M+N)logM)   |   Space Complexity:   O(1)
--- Passed few custom created testcases as below
'''

#   Stored the info of routes as an object instead of list
class RouteInfo:

    def __init__(self, id, route):
        self.id = id
        self.route = route

    #   custom =, <, <=, >, >=, != operators defined for the class
    def __eq__(self, other):
        return self.route == other.route

    def __ne__(self, other):
        return self.route != other.route

    def __lt__(self, other):
        return self.route < other.route

    def __le__(self, other):
        return self.route <= other.route

    def __gt__(self, other):
        return self.route > other.route

    def __ge__(self, other):
        return self.route >= other.route

    def __repr__(self):
        return '%d %d' % (self.id, self.route)


class OptimizeAirRoutes:

    def __binarySearch(self, arr, nearestLess):

        #   initializations
        lo = 0
        hi = len(arr) - 1

        #   terminating condition: lo and high should cross
        while (lo <= hi):
            mid = lo + int( (hi - lo) / 2)

            #   exactly equal to complement => return
            if (arr[mid].route == nearestLess):
                return mid

            #   move left
            elif (arr[mid].route > nearestLess):
                hi = mid - 1

            #   move right
            else:
                lo = mid + 1

        return hi                       #   hi index contains the nearest value to the complement after terminating the loop

    def optimize(self, forward, backward, target):

        result = []

        #   perform sorting on smaller array
        if len(forward) < len(backward):
            return self.optimize(backward, forward, target)

        #   edge case check
        if (forward == None or len(forward) == 0):
            return result

        maxValue = 0

        backward.sort()         #   sort the smaller array

        for i in range(len(forward)):

            complement = target - forward[i].route
            index = self.__binarySearch(backward, complement)   #   binary search to get the nearest complement

            if (index != -1):
                currSum = forward[i].route + backward[index].route      #  compute the sum to check
                if (currSum >= maxValue):
                    if (currSum > maxValue):    result = []             #   if strictly greater => create a new final list
                    maxValue = max(maxValue, currSum)
                    result.append([forward[i].id, backward[index].id])  #   add the pair

        return result

def main():
    optRoutes = OptimizeAirRoutes()

    #   test case 1
    forward = [RouteInfo(1, 4000), RouteInfo(2, 2000), RouteInfo(3, 6000)]
    backward = [RouteInfo(1, 4000), RouteInfo(2, 2500), RouteInfo(3, 2800)]
    target = 7000

    result = optRoutes.optimize(forward, backward, target)
    print(result)                                                                                       #   [[1, 3]]

    #   test case 2
    forward = [RouteInfo(1, 4000), RouteInfo(2, 2000), RouteInfo(3, 6000)]
    backward = [RouteInfo(1, 4000), RouteInfo(2, 2000), RouteInfo(3, 2800)]
    target = 6000                                                                                       #   [[1, 2], [2, 1]]

    result = optRoutes.optimize(forward, backward, target)
    print(result)

    #   test case 3
    forward = [RouteInfo(1, 3000), RouteInfo(2, 7000), RouteInfo(3, 5000), RouteInfo(4, 10000)]
    backward = [RouteInfo(1, 2000), RouteInfo(2, 5000), RouteInfo(3, 4000), RouteInfo(4, 3000)]
    target = 10000                                                                                      #   [[2, 4], [3, 2]]

    result = optRoutes.optimize(forward, backward, target)
    print(result)

if __name__ == '__main__':
    main()