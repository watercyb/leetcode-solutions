/*
 * Problem: 3260. Find the Largest Palindrome Divisible by K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-largest-palindrome-divisible-by-k/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public String largestPalindrome(int n, int k) {
        int[] mods = new int[n];
        mods[0] = 1 % k;
        int mod = mods[0] * 9 % k;
        for (int i = 1; i < n && mods[i - 1] > 0; i++) {
            mods[i] = mods[i - 1] * 10 % k;
            mod = (mod + mods[i] * 9) % k;
        }
        int[] modSums = new int[(n + 1) / 2];
        for (int i = 0; i < modSums.length - 1; i++) {
            modSums[i] = (mods[i] + mods[n - 1 - i]) % k;
        }
        modSums[modSums.length - 1] = modSums.length - 1 == n - modSums.length ? mods[modSums.length - 1]
                : (mods[modSums.length - 1] + mods[n - modSums.length]) % k;
        int[][][] DP = new int[modSums.length + 1][k][];
        DP[0][0] = new int[] { 1, 0 };
        for (int i = modSums.length - 1; i >= 0; i--) {
            int idx = modSums.length - i;
            boolean[] seens = new boolean[k];
            for (int j = 9; j >= 0; j--) {
                int modCurrent = modSums[i] * j % k;
                if (seens[modCurrent])
                    continue;
                seens[modCurrent] = true;
                for (int l = 0; l < k; l++) {
                    if (DP[idx - 1][l] == null)
                        continue;
                    int modNext = (modCurrent + l) % k;
                    if (DP[idx][modNext] == null) {
                        DP[idx][modNext] = new int[] { l, j };
                    }
                }
            }
        }
        StringBuilder SB = new StringBuilder();
        int idx = 0;
        for (int i = modSums.length; i > 0; i--) {
            SB.append(DP[i][idx][1]);
            idx = DP[i][idx][0];
        }
        if (n % 2 == 0) {
            return SB.toString() + SB.reverse().toString();
        } else {
            String res = SB.toString();
            SB.setLength(SB.length() - 1);
            return res + SB.reverse().toString();
        }
    }
}
