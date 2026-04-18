/*
 * Problem: 1529. Minimum Suffix Flips
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-suffix-flips/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minFlips(String target) {
        int bit = 0;
        int res = 0;
        int n = target.length();
        for (int i = 0; i < n; i++) {
            int num = target.charAt(i) - '0';
            res += num ^ bit;
            bit = num;
        }
        return res;
    }
}
