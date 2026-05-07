/*
 * Problem: 3494. Find the Minimum Amount of Time to Brew Potions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] DP = new long[skill.length + 1];
        for (int i = 0; i < skill.length; i++) {
            DP[i + 1] = DP[i] + skill[i] * mana[0];
        }
        long offset = 0;
        long[] DPNext = new long[skill.length + 1];
        for (int i = 1; i < mana.length; i++) {
            DPNext[0] = DP[skill.length];
            long diff = Long.MAX_VALUE;
            for (int j = 0; j < skill.length; j++) {
                DPNext[j + 1] = DPNext[j] + skill[j] * mana[i];
                diff = Math.min(DPNext[j] - DP[j + 1], diff);
            }
            offset += diff;
            long[] temp = DP;
            DP = DPNext;
            DPNext = temp;
        }
        return DP[skill.length] - offset;
    }
}
