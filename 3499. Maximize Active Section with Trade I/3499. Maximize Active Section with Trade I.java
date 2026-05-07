/*
 * Problem: 3499. Maximize Active Section with Trade I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-active-section-with-trade-i/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int count = Integer.MIN_VALUE;
        int prvCount = Integer.MIN_VALUE;
        int prv = '1';
        int res = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == '0') {
                if (prv == '1') {
                    sum = Math.max(count + prvCount, sum);
                    prvCount = count;
                    count = 1;
                } else {
                    count++;
                }
            } else {
                res++;
            }
            prv = chr;
        }
        sum = Math.max(count + prvCount, sum);
        return res + sum;
    }
}
