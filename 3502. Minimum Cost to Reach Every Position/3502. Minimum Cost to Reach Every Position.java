/*
 * Problem: 3502. Minimum Cost to Reach Every Position
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-cost-to-reach-every-position/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] minCosts(int[] cost) {
        int[] res = new int[cost.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cost.length; i++) {
            min = Math.min(cost[i], min);
            res[i] = min;
        }
        return res;
    }
}
