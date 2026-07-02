

class Solution {
    public List<List<Integer>> optimalUtilization(
        int maxTravelDist,
        List<List<Integer>> forwardRouteList,
        List<List<Integer>> returnRouteList
    ) {
        forwardRouteList.sort((a, b) -> a.get(1) - b.get(1));
        returnRouteList.sort((a, b) -> a.get(1) - b.get(1));

        int left = 0;
        int right = returnRouteList.size() - 1;
        int best = -1;

        List<List<Integer>> result = new ArrayList<>();

        while (left < forwardRouteList.size() && right >= 0) {
            int sum = forwardRouteList.get(left).get(1) + returnRouteList.get(right).get(1);

            if (sum > maxTravelDist) {
                right--;
            } else {
                if (sum > best) {
                    best = sum;
                    result.clear();
                }

                if (sum == best) {
                    int r = right;

                    while (r >= 0 && returnRouteList.get(r).get(1).equals(returnRouteList.get(right).get(1))) {
                        result.add(Arrays.asList(
                            forwardRouteList.get(left).get(0),
                            returnRouteList.get(r).get(0)
                        ));
                        r--;
                    }
                }

                left++;
            }
        }

        return result;
    }
}