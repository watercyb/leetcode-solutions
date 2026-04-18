/*
 * Problem: 1503. Last Moment Before All Ants Fall Out of a Plank
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max=0;
        for (int l:left) {
            max=Math.max(l,max);
        }
        for (int r:right) {
            max=Math.max(n-r,max);
        }
        return max;
    }
}
