// Time Complexity : O(mlog(m) + nlogn)
// Space Complexity : O(1)


public class Main {
    public static List<List<Integer>> closestSum(List<List<Integer>> listA, List<List<Integer>> listB, int target) {
        listA.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        listB.sort((a, b) -> a.get(1).compareTo(b.get(1)));

        int i = 0;
        int j = listB.size() - 1;

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<List<Integer>> resSoFar = new ArrayList<List<Integer>>();
        int closestSum = Integer.MIN_VALUE;

        while (i < listA.size() && j >= 0) {
            List<Integer> aVal = listA.get(i);
            List<Integer> bVal = listB.get(j);

            int sum = aVal.get(1) + bVal.get(1);
            if (target - sum < 0) {
                j--;
            } else {
                if (sum > closestSum) {
                    closestSum = sum;
                    resSoFar.clear();
                    resSoFar.add(new ArrayList<>() {{
                        add(aVal.get(0));
                        add(bVal.get(0));
                    }});
                } else if (sum == closestSum) {
                    resSoFar.add(new ArrayList<>() {{
                        add(aVal.get(0));
                        add(bVal.get(0));
                    }});
                }
                i++;
            }
        }
        res.addAll(resSoFar);
        return res;
    }
} 