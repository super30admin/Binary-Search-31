# Time Complexity :- O(mxn)
#Space Complexity :- O(1)

class Solution:
    def findCombination(list1, list2):
        maxValue = 0
        arrayList = []
        for i in range(len(list1)):
            for j in range(len(list2)):
                if list1[i][1]+ list2[j][1] < 10 and list1[i][1]+ list2[j][1] > maxValue:
                    maxValue = list1[i][1]+ list2[j][1]
                    arrayList.append([list1[i][0],list2[j][0]])
        return arrayList

# Approach 2 :
# Time Complexity :- O(m+n)
#Space Complexity :- O(1)

class Solution :
    def findCombination(list1, list2):
        start = 0
        end = len(list2)-1
        maxValue = 0
        arrayList = []
        while start > len(list1)-1 or end <0:
            if list1[start][1] + list2[end][1] < 10:
                start +=1
                if list1[start][1] + list2[end][1] > maxValue:
                    arrayList.append([list1[start]][0], list2[end][0]])
            else:
                end -=1
        return arrayList

