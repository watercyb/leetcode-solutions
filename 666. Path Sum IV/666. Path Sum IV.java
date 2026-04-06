/*
 * Problem: 666. Path Sum IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/path-sum-iv/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int pathSum(int[] nums) {
        int[] values = new int[49];
        Arrays.fill(values, -1);
        for (int num : nums) {
            values[num / 10] = num % 10;
        }
        return dfs(values, 1, 1, values[11]);
    }

    public int dfs(int[] values, int d, int p, int sum) {
        int r = (d + 1) * 10 + p * 2;
        int l = r - 1;
        int res = 0;
        if (d == 4 || (values[l] == -1 && values[r] == -1)) {
            return sum;
        } else {
            if (values[l] != -1)
                res = dfs(values, d + 1, p * 2 - 1, sum + values[l]);
            if (values[r] != -1)
                res += dfs(values, d + 1, p * 2, sum + values[r]);
        }
        return res;
    }
}
