/*
 * Problem: 1989. Maximum Number of People That Can Be Caught in Tag
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-people-that-can-be-caught-in-tag/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int j = 0;
        int res = 0;
        for (int i = 0; i < team.length; i++) {
            if (team[i] == 0)
                continue;
            if (j < i - dist)
                j = i - dist;
            int lim = Math.min(i + dist + 1, team.length);
            while (j < lim && team[j] == 1) {
                j++;
            }
            if (j < lim) {
                res++;
                j++;
            }
        }
        return res;
    }
}
