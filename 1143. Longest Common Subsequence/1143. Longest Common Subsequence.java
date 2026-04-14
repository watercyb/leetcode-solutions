/*
 * Problem: 1143. Longest Common Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-common-subsequence/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int rl=text1.length();
        int cl=text2.length();
        char[] chrs1=text1.toCharArray();
        char[] chrs2=text2.toCharArray();
        int[] dp=new int[cl+1];
        for (int i=1;i<=rl;i++) {
            int prv=0;
            for (int j=1;j<=cl;j++) {
                int tmp=dp[j];
                if (chrs1[i-1]==chrs2[j-1]) {
                    dp[j]=prv+1;
                } else {
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                prv=tmp;
            }
        }
        return dp[cl];
    }
}
