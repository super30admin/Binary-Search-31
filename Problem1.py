#Time complexity is O(m+n) where m is the number of elements in array1 and n is the number of elements in array2
#Space complexity is O(min(m,n))
#No issues faced while coding
#Code rannsuccessfully on leetcode compiler
class Opt(object):
    def optimal(self,x,arr1,arr2):
        result=[]
        #we are taking two pointers 
        pointer1=0
        pointer2=len(arr2)-1
        #We will be looping until the pointers reach the terminating conditions of their respective arrays
        while(pointer1<len(arr1) and pointer2>=0):
            #Here a and b represents their repsective values in arr2 and arr2
            a=arr1[pointer1][1]
            b=arr2[pointer2][1]
            #Based on their sum they will go into foloowing conditional statement
            if(a+b<x):
                pointer1+=1
            elif(a+b>x):
                pointer2-=1
            else:
                result.append([arr1[pointer1][0],arr2[pointer2][0]])
                pointer1+=1
                pointer2-=1
        #We will be finally returning the result
        return result


solution=Opt()
x=5000
arr1 = [[1, 2000], [2, 3000], [3, 4000]]
arr2 = [[1, 5000], [2, 3000]]
print(solution.optimal(x,arr1,arr2))