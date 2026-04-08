/*
 * Problem: 754. Reach a Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reach-a-number/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int i = (int) Math.ceil((Math.sqrt(1 + 8l * target) - 1) / 2);
        long n = (long) (i + 1) * i / 2;
        if (n > target && (n - target) % 2 == 1) {
            if (i % 2 == 0)
                return i + 1;
            return i + 2;
        }
        return i;
    }
}
