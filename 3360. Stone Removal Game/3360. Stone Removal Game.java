/*
 * Problem: 3360. Stone Removal Game
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/stone-removal-game/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public boolean canAliceWin(int n) {
        boolean res = false;
        int stp = 10;
        n -= stp;
        while (n >= 0) {
            res = !res;
            n -= --stp;
        }
        return res;
    }
}
