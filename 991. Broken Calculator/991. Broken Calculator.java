/*
 * Problem: 991. Broken Calculator
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/broken-calculator/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while (target > startValue) {
            res += target % 2 + 1;
            target = (target + target % 2) / 2;
        }
        return res + startValue - target;
    }
}
