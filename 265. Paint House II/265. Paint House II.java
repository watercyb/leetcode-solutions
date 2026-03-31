/*
 * Problem: 265. Paint House II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/paint-house-ii/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int minCostII(int[][] costs) {
        int min1 = 0;
        int min2 = 0;
        int idx = -1;
        for (int i = 0; i < costs.length; i++) {
            int min1Next=Integer.MAX_VALUE;
            int min2Next=Integer.MAX_VALUE;
            int idxNext = -1;
            for (int j = 0; j < costs[0].length; j++) {
                int tmp = j == idx ? min2 + costs[i][j] : min1 + costs[i][j];
                if (tmp <= min1Next) {
                    min2Next = min1Next;
                    min1Next = tmp;
                    idxNext = j;
                } else if (tmp < min2Next) {
                    min2Next = tmp;
                }
            }
            min1 = min1Next;
            min2 = min2Next;
            idx = idxNext;
        }
        return min1;
    }
}
