/*
 * Problem: 2147. Number of Ways to Divide a Long Corridor
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1_000_000_007;
        char[] chrs = corridor.toCharArray();
        int sum = 0;
        int i = 0;
        while (i < chrs.length && chrs[i] == 'P')
            i++;
        int count = 0;
        int res = 1;
        while (i < chrs.length) {
            if (chrs[i] == 'S') {
                if (sum % 2 == 0 && count > 0) {
                    res = (int) ((long) res * (count + 1) % mod);
                }
                count = 0;
                sum++;
            } else {
                count++;
            }
            i++;
        }
        if (sum % 2 == 1 || sum == 0)
            return 0;
        return res;
    }
}
