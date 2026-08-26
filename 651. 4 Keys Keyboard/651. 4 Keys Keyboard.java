/*
 * Problem: 4 Keys Keyboard
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/4-keys-keyboard/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int maxA(int n) {
        if (n < 3)
            return n;
        int[] DP = new int[n];
        for (int i = 0; i < n; i++) {
            DP[i] = i + 1;
        }
        for (int i = 2; i < n; i++) {
            int tmp = DP[i - 2];
            for (int j = i + 1; j < Math.min(i + 4, n); j++) {
                tmp += DP[i - 2];
                DP[j] = Math.max(tmp, DP[j]);
            }
        }
        return DP[n - 1];
    }

}
