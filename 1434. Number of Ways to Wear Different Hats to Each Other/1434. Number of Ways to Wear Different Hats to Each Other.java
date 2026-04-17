/*
 * Problem: 1434. Number of Ways to Wear Different Hats to Each Other
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int mod = 1_000_000_007;
        int n = hats.size();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= 40; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int hat : hats.get(i)) {
                lists.get(hat).add(i);
            }
        }
        long[] DP = new long[1 << n];
        DP[0] = 1;
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            masks[i] = 1 << i;
        }
        for (int i = 1; i <= 40; i++) {
            if (lists.get(i).isEmpty())
                continue;
            long[] DPNext = DP.clone();
            for (int p : lists.get(i)) {
                for (int k = 0; k < DP.length; k++) {
                    if ((k & masks[p]) == 0)
                        DPNext[k + masks[p]] += DP[k];
                }
            }
            DP = DPNext;
        }
        return (int) (DP[(1 << n) - 1] % mod);
    }
}
