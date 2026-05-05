/*
 * Problem: 3232. Find if Digit Game Can Be Won
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-if-digit-game-can-be-won/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums) {
            if (num < 10) {
                sum1 += num;
            } else {
                sum2 += num;
            }
        }
        return sum1 != sum2;
    }
}
