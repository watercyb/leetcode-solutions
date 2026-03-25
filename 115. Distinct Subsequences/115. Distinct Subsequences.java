/*
 * Problem: 115. Distinct Subsequences
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/distinct-subsequences/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int numDistinct(String s, String t) {
        char[] chrsS = s.toCharArray();
        char[] chrsT = t.toCharArray();
        int[] DP = new int[chrsS.length + 1];
        for (int i = 0; i <= chrsS.length; i++) {
            DP[i] = 1;
        }
        int l=chrsS.length-chrsT.length;
        for (int i = 0; i < chrsT.length; i++) {
            int dig = DP[i];
            DP[i] = 0;
            for (int j = i; j <= l+i; j++) {
                int digNext = DP[j + 1];
                DP[j + 1] = DP[j];
                if (chrsT[i] == chrsS[j]) {
                    DP[j + 1] += dig;
                }
                dig = digNext;
            }
        }
        return DP[chrsS.length];
    }
}
