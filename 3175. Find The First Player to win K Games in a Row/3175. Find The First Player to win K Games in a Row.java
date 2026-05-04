/*
 * Problem: 3175. Find The First Player to win K Games in a Row
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-first-player-to-win-k-games-in-a-row/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int count = 0;
        int res = 0;
        int num = skills[0];
        for (int i = 1; i < skills.length && count < k; i++) {
            if (num > skills[i]) {
                count++;
            } else {
                count = 1;
                num = skills[i];
                res = i;
            }
        }
        return res;
    }
}
