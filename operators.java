// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, 0, "", 0, 0, target);
        return result;
    }

    private void helper(String num, int pivot, String path, long calc, long tail, int target) {
        if (pivot == num.length()) {
            if (target == calc) {
                result.add(path);
            }
            return;
        }
        for (int i = pivot; i < num.length(); i++) {
            long cur = Long.parseLong(num.substring(pivot, i + 1));
            if (pivot == 0) {
                helper(num, i + 1, path + cur, cur, cur, target);
            } else {
                helper(num, i + 1, path + '+' + cur, calc + cur, cur, target);
                helper(num, i + 1, path + '-' + cur, calc - cur, -cur, target);
                helper(num, i + 1, path + '*' + cur, calc - tail + tail * cur, tail * cur, target);
            }
        }
    }
}