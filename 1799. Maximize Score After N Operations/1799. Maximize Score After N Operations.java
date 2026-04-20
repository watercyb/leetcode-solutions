/*
 * Problem: 1799. Maximize Score After N Operations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-score-after-n-operations/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maxScore(int[] nums) {
        int[][] gcd = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                gcd[i][j] = GCD(nums[i], nums[j]);
            }
        }
        int max = 1 << nums.length;
        int[] DP = new int[max];
        for (int i = 0; i < max; i++) {
            int count = Integer.bitCount(i);
            if ((count & 1) == 1)
                continue;
            count = count / 2 + 1;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0)
                    continue;
                for (int k = j + 1; k < nums.length; k++) {
                    if ((i & (1 << k)) != 0)
                        continue;
                    int idx = i + (1 << j) + (1 << k);
                    DP[idx] = Math.max(DP[i] + count * gcd[j][k], DP[idx]);
                }
            }
        }
        return DP[DP.length - 1];
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
