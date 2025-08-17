# TC: O(m*n)
# SC: O(1)
# def sol(a,b,target):
#   maxi=float('-inf')
#   result=[]
#   for l1 in a:
#     for l2 in b:
#       cur_sum=l1[1]+l2[1]
#       if cur_sum<=target:
#         if cur_sum>maxi :
#           maxi=cur_sum
#           result=[]
#           result.append([l1[0],l2[0]])
#         elif cur_sum==maxi:
#           result.append([l1[0],l2[0]])
#   return result

# Two pointer approach
# TC: O(m+n)
# SC: O(1)
# def sol(a,b,target):
#   maxi=float('-inf')
#   result=[]
#   l1=0
#   l2=len(b)-1
#   while l1<len(a) and l2>=0:
#     cur_sum=a[l1][1]+b[l2][1]
#     if cur_sum<=target:
#       if cur_sum>maxi:
#         maxi=cur_sum
#         result=[]
#         result.append([a[l1][0],b[l2][0]])
#       elif cur_sum==maxi:
#         result.append([a[l1][0],b[l2][0]])
#       l1+=1
#     else:
#       l2-=1
#   return result

# Binary Search Approach
# TC: O(mlog(n))
# SC: O(1)
def sol(a,b,target):
  maxi=float('-inf')
  result=[]
  
  def bs(b,v):
    tar=target-v
    l=0
    h=len(b)-1
    while l<=h:
      mid=l+(h-l)//2
      if b[mid][1]==tar: return mid
      elif b[mid][1]<tar:
        if mid!=h and b[mid+1][1]<=tar:
          l=mid+1
        else:
          return mid
      else:
        h=mid-1
    return -1
      
  for l in a:
    val=bs(b,l[1])
    if val!=-1:
      if b[val][1]+l[1]>maxi:
        maxi=b[val][1]+l[1]
        result=[]
        result.append([l[0],b[val][0]])
      elif b[val][1]+l[1]==maxi:
        result.append([l[0],b[val][0]])
  return result

print(sol( [[1, 8], [2, 7], [3, 14]],[[1, 5], [2, 10], [3, 14]],20))
print(sol( [[1, 3], [2, 5], [3, 7], [4, 10]],[[1, 2], [2, 3], [3, 4], [4, 5]],10))
print(sol( [[1,2000],[2,4000],[3,6000]],[[1,2000]],7000))