/*
 * Problem: 2976. Minimum Cost to Convert String I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-convert-string-i/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] costs = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j)
                    costs[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < cost.length; i++) {
            costs[original[i] - 'a'][changed[i] - 'a'] = Math.min(costs[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (costs[j][i] == Integer.MAX_VALUE)
                    continue;
                for (int k = 0; k < 26; k++) {
                    if (costs[i][k] == Integer.MAX_VALUE)
                        continue;
                    costs[j][k] = Math.min(costs[j][i] + costs[i][k], costs[j][k]);
                }
            }
        }
        long res = 0;
        for (int i = 0; i < source.length(); i++) {
            int a = source.charAt(i) - 'a';
            int b = target.charAt(i) - 'a';
            if (costs[a][b] == Integer.MAX_VALUE)
                return -1;
            res += costs[a][b];
        }
        return res;
    }
}
