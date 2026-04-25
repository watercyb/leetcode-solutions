/*
 * Problem: 2218. Maximum Value of K Coins From Piles
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] DP = new int[k + 1];
        int res = 0;
        for (int i = 0; i < piles.size(); i++) {
            int[] DPNext = DP.clone();
            List<Integer> pile = piles.get(i);
            int sum = 0;
            for (int j = 0; j < pile.size(); j++) {
                sum += pile.get(j);
                for (int l = 0; l < k - j; l++) {
                    DPNext[l + j + 1] = Math.max(DP[l] + sum, DPNext[l + j + 1]);
                }
            }
            res = Math.max(DPNext[k], res);
            DP = DPNext;
        }
        return res;
    }
}
