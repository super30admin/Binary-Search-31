//Time: O(Nlog(N))
//Space: O(N)
public class Problem89 {

    public List<int[]> findOptimalPairs(List<int[]> a, List<int[]> b, int target) {
        // Sort list 'a' and 'b' by the second element (value)
        Collections.sort(a, (p1, p2) -> p1[1] - p2[1]);
        Collections.sort(b, (p1, p2) -> p1[1] - p2[1]);

        // Initialize variables to track the best sum and the result list
        int maxSum = Integer.MIN_VALUE;
        List<int[]> result = new ArrayList<>();

        // Two pointers
        int i = 0; // pointer for list 'a'
        int j = b.size() - 1; // pointer for list 'b'

        // Iterate through the lists using the two-pointer technique
        while (i < a.size() && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1]; // Sum of values from 'a' and 'b'

            // If the sum exceeds the target, move the pointer 'j' to a smaller value
            if (sum > target) {
                j--;
            } else {
                // If the sum is closer to the target or matches the best sum
                if (sum >= maxSum) {
                    // If this sum is larger than the previous best sum, reset the result list
                    if (sum > maxSum) {
                        result.clear();
                        maxSum = sum; // Update the maximum sum found
                    }
                    // Add the pair of IDs to the result list
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    
                    // Handle multiple pairs with the same sum but different values in 'b'
                    int index = j - 1;
                    while (index >= 0 && b.get(index)[1] == b.get(j)[1]) {
                        result.add(new int[]{a.get(i)[0], b.get(index)[0]});
                        index--;
                    }
                }
                // Move the pointer 'i' to try the next value in 'a'
                i++;
            }
        }

        return result; // Return the list of pairs
    }
}
