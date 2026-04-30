/*
 * Problem: 2739. Total Distance Traveled
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/total-distance-traveled/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        while (mainTank >= 5) {
            int n = mainTank / 5;
            res += n * 50;
            if (n > additionalTank) {
                mainTank = mainTank % 5 + additionalTank;
                additionalTank = 0;
            } else {
                mainTank = mainTank % 5 + n;
                additionalTank -= n;
            }
        }
        return res + mainTank * 10;
    }
}
