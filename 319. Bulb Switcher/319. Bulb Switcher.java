/*
 * Problem: 319. Bulb Switcher
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bulb-switcher/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public int bulbSwitch(int n) {
        int res = 0;
        int lim = (int) (Math.sqrt(n));
        for (int i = 1; i <= lim; i++) {
            res++;
        }
        return res;
    }
}
