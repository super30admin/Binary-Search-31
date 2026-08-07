/*Question: given a list of forward routes and reverse routes and the maxTravelAllowed: return the most optimal pairs
ex1: maxTravelDist = 10000
forwardRouteList[] = [1,3000],[2,5000],[3,7000],[4,10000]
returnRouteList[] = [1,2000],[2,3000],[3,4000],[4,5000]
Op: [[2,4],[3,2]]

ex2:
maxTravelDist = 10000
forwardRouteList[] = [1,3000],[2,5000],[3,7000]
returnRouteList[] = [1,4000],[2,6000],[3,1000]
Op: [[2,1],[3,2]]

Here no pair has sum equal to 10000 but 2 pairs have 9000, so this will be the answer in this case.

Approach: firstly did it in O(N^2) but it was giving TLE for half TCs.
Then used 2 maps, first stored maxTravelDist - forwardRouteList[i][1] and second stored dist as key and index as values. Then iterate over fwdMap and find if same value is present in reverseMap.
Couldn't pass all the TCs. 10/17 were passed. */

int[][] forwardRouteList =
{
    new[] { 1, 3000 },
    new[] { 2, 5000 },
    new[] { 3, 7000 },
    new[] { 4, 10000 }
};

int[][] returnRouteList =
{
    new[] { 1, 2000 },
    new[] { 2, 3000 },
    new[] { 3, 4000 },
    new[] { 4, 5000 }
};
int maxTravelDist = 10000;
Array.Sort(forwardRouteList, (a, b) => a[1].CompareTo(b[1]));
Array.Sort(returnRouteList, (a, b) => a[1].CompareTo(b[1]));
List<int[]> result = new List<int[]>();
int maxSum = -1;
int i=0,j=returnRouteList.Length-1;
while(i<forwardRouteList.Length && j>=0)
{
    int sum=forwardRouteList[i][1]+returnRouteList[j][1];
    if(sum>maxTravelDist)
    {
        j--;
    }
    else
    {
        if(sum>maxSum)
        {
            maxSum = sum;
            result.Clear();
            result.Add(new int[] { forwardRouteList[i][0], returnRouteList[j][0] });
        }
        else if(sum == maxSum)
        {
            result.Add(new int[] { forwardRouteList[i][0], returnRouteList[j][0] });
        }
        i++;
    }
}
console.WriteLine("Optimal Pairs:");
foreach(var pair in result)
{
    console.WriteLine($"[{pair[0]}, {pair[1]}]");
}

