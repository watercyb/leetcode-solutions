/*
 * Problem: 1639. Number of Ways to Form a Target String Given a Dictionary
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int numWays(String[] words, String target) {
        if (words[0].length() < target.length())
            return 0;
        int mod = 1_000_000_007;
        char[] chrs = target.toCharArray();
        int[][] counts = new int[words[0].length()][26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                counts[i][word.charAt(i) - 'a']++;
            }
        }
        long[] DP = new long[counts.length + 1];
        long prv = 1;
        for (int i = 0; i < chrs.length; i++) {
            for (int j = i; j < counts.length; j++) {
                long sum = (prv * counts[j][chrs[i] - 'a']) % mod;
                prv = (prv + DP[j]) % mod;
                DP[j] = sum;
            }
            prv = DP[i];
        }
        long res = 0;
        for (int i = chrs.length - 1; i < counts.length; i++) {
            res = (res + DP[i]) % mod;
        }
        return (int) res;
    }
}
