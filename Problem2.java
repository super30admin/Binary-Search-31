/*
H-Index ii
approach: find max value for which elements on right side are >= max value, if there exists no such value
then answer will be equal to the number of elements on the right.
time: O(log N)
space: O(1)
 */
public class Problem2 {
    public int hIndex(int[] citations) {

        int l = 0, h = citations.length-1, n = citations.length;

        while(l<=h) {
            int m = l+(h-l)/2;

            if(citations[m]<n-m) l = m+1;
            else h = m-1;
        }

        return n-l;
    }
}
