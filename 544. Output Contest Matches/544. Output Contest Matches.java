/*
 * Problem: 544. Output Contest Matches
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/output-contest-matches/
 * Language: java
 * Date: 2026-04-03
 */


class Solution {
    public String findContestMatch(int n) {
        StringBuilder[] SB = new StringBuilder[n / 2];
        for (int i = 1; i <= n / 2; i++) {
            SB[i - 1] = new StringBuilder().append('(').append(i).append(',').append(n + 1 - i).append(')');
        }
        while (SB.length > 1) {
            StringBuilder[] SBNext = new StringBuilder[SB.length / 2];
            for (int i = 0; i < SBNext.length; i++) {
                SBNext[i] = new StringBuilder().append('(').append(SB[i]).append(',').append(SB[SB.length - 1 - i])
                        .append(')');
            }
            SB = SBNext;
        }
        return SB[0].toString();
    }
}
