/*
 * Problem: 72. Edit Distance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/edit-distance/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] DP = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            DP[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            DP[0][j] = j;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    DP[i + 1][j + 1] = DP[i][j];
                } else {
                    DP[i + 1][j + 1] = Math.min(Math.min(DP[i][j + 1], DP[i + 1][j]), DP[i][j]) + 1;
                }
            }
        }
        return DP[word1.length()][word2.length()];
    }
}
