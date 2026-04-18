/*
 * Problem: 1595. Minimum Cost to Connect Two Groups of Points
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int[][] costs = new int[cost.size()][];
        int[] mins = new int[cost.getFirst().size()];
        Arrays.fill(mins, Integer.MAX_VALUE);
        for (int i = 0; i < costs.length; i++) {
            List<Integer> list = cost.get(i);
            costs[i] = new int[list.size()];
            for (int j = 0; j < costs[i].length; j++) {
                costs[i][j] = list.get(j);
                mins[j] = Math.min(costs[i][j], mins[j]);
            }
        }
        return dfs(costs, new int[costs.length][1 << costs[0].length], 0, 0, mins);
    }

    public int dfs(int[][] costs, int[][] meme, int i, int h, int[] mins) {
        if (i == costs.length)
            return getSum(mins, h);
        if (meme[i][h] != 0)
            return meme[i][h];
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < costs[0].length; j++) {
            res = Math.min(dfs(costs, meme, i + 1, h | (1 << j), mins) + costs[i][j], res);
        }
        return meme[i][h] = res;
    }

    public int getSum(int[] mins, int h) {
        int res = 0;
        for (int i = 0; i < mins.length; i++) {
            if ((h & (1 << i)) == 0)
                res += mins[i];
        }
        return res;
    }
}
