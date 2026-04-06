/*
 * Problem: 656. Coin Path
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/coin-path/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        if (coins[coins.length - 1] == -1)
            return new ArrayList<>();
        int[] MQ = new int[coins.length];
        int[] MQIdx = new int[coins.length];
        int l = 0;
        int r = 1;
        MQIdx[0] = coins.length - 1;
        for (int i = coins.length - 2; i >= 0; i--) {
            if (coins[i] == -1)
                continue;
            while (l < r && MQIdx[l] - maxJump > i) {
                l++;
            }
            if (l == r)
                return new ArrayList<>();
            int min = MQ[l];
            int idx = MQIdx[l];
            int sum = coins[i] + min;
            while (r > l && MQ[r - 1] >= sum) {
                r--;
            }
            MQ[r] = sum;
            MQIdx[r++] = i;
            coins[i] = idx;
        }
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        while (idx != coins.length - 1) {
            res.add(idx + 1);
            idx = coins[idx];
        }
        res.add(coins.length);
        return res;
    }
}
