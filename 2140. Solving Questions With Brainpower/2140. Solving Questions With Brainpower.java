/*
 * Problem: 2140. Solving Questions With Brainpower
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/solving-questions-with-brainpower/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long mostPoints(int[][] questions) {
        long[] DP = new long[questions.length];
        DP[questions.length - 1] = questions[questions.length - 1][0];
        for (int i = questions.length - 2; i >= 0; i--) {
            int next = questions[i][1] + i + 1;
            if (next >= questions.length) {
                DP[i] = Math.max(questions[i][0], DP[i + 1]);
            } else {
                DP[i] = Math.max(DP[next] + questions[i][0], DP[i + 1]);
            }
        }
        return DP[0];
    }
}
