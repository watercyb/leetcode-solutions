/*
 * Problem: 1542. Find Longest Awesome Substring
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-longest-awesome-substring/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int longestAwesome(String s) {
        char[] chrs = s.toCharArray();
        int[] DP = new int[1 << 10];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0] = -1;
        int res = 1;
        int h = 0;
        for (int i = 0; i < chrs.length; i++) {
            h ^= 1 << (chrs[i] - '0');
            if (DP[h] > i) {
                DP[h] = i;
            } else {
                res = Math.max(res, i - DP[h]);
            }
            for (int j = 0; j <= 9; j++) {
                res = Math.max(res, i - DP[h ^ (1 << j)]);
            }
        }
        return res;
    }
}
