/*
 * Problem: 3864. Minimum Cost to Partition a Binary String
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-partition-a-binary-string/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long minCost(String s, int encCost, int flatCost) {
        return dfs(s.toCharArray(), 0, s.length() - 1, flatCost, encCost);
    }

    public long dfs(char[] chrs, int l, int r, int flatCost, int encCost) {
        int len = r - l + 1;
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (chrs[i] == '1')
                count++;
        }
        long res = count == 0 ? flatCost : (long) len * count * encCost;
        if (len % 2 == 1)
            return res;
        int mid = (l + r) >>> 1;
        res = Math.min(res, dfs(chrs, l, mid, flatCost, encCost) + dfs(chrs, mid + 1, r, flatCost, encCost));
        return res;
    }
}
