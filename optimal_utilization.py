# Time Complexity :
# O(N)

# Space Complexity :
# O(1) 

# Did this code successfully run on Leetcode :
#Yes

#We use a 2 pointer appraoch for this. We start first pointer at beginning of first array and second one at end of second arary.
#We sum them, check if the distance is lesser than target and lesser than existing closest distance, if it is, the IDs are added to the solution (after clearning any old existing solutions)
#If the current distance is same as the old one, then it is appeneded to the existing list of solutions

class solution:
    def solve(self,a,b,target):
        ptr1 = 0
        ptr2 = len(b) - 1
        
        if len(a) == 0 and len(b) == 0:
            return []
        
        solution = []
        closest_distance = 10**10
        while (ptr1 < len(a) and ptr2 >= 0 ):
                
            distance = a[ptr1][1] + b[ptr2][1]
            if (target - distance) >= 0  and (target - distance) <= closest_distance :
                if (target - distance) == closest_distance:
                    solution.append([a[ptr1][0],b[ptr2][0]])
                else :
                    solution = []
                    solution.append([a[ptr1][0],b[ptr2][0]])
                closest_distance = target - distance
            
            if distance < target : 
                ptr1 += 1
            elif distance > target :
                ptr2 -= 1
            else :
                ptr1 += 1
                ptr2 -=1
                    
        return solution
    
if __name__ == "__main__": 

    obj = solution()
    a = [[1, 3], [2, 5], [3, 7], [4, 10]]
    b = [[1, 2], [2, 3], [3, 4], [4, 5]]
    target = 10

    print (obj.solve(a,b,target)) # [[2, 4], [3, 2]]

    a = [[1, 2], [2, 4], [3, 6]]
    b = [[1, 2]]
    target = 7

    print (obj.solve(a,b,target)) # [[2, 1]]

    a = [[1, 5], [2, 5]]
    b = [[1, 5], [2, 5]]
    target = 10

    print (obj.solve(a,b,target)) # [[1, 2], [2, 1]]
    
    a = []
    b = [[1,5]]
    target = 5
    
    print (obj.solve(a,b,target))  #[]
