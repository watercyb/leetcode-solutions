/*
 * Problem: 2214. Minimum Health to Beat Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-health-to-beat-game/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long res = 1;
        int max = 0;
        for (int in : damage) {
            res += in;
            if (max < in)
                max = in;
        }
        res -= Math.min(armor, max);
        return res;
    }
}
