/*
 * Problem: 2483. Minimum Penalty for a Shop
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-penalty-for-a-shop/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int bestClosingTime(String customers) {
        char[] chrs = customers.toCharArray();
        int diff = 0;
        int res = 0;
        int max = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == 'Y') {
                diff++;
            } else {
                diff--;
            }
            if (diff > max) {
                max = diff;
                res = i + 1;
            }
        }
        return res;
    }
}
