/*
 * Problem: 1769. Minimum Number of Operations to Move All Balls to Each Box
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] minOperations(String boxes) {
        char[] chrs = boxes.toCharArray();
        int[] res = new int[chrs.length];
        int sum = 0;
        int total = 0;
        for (int i = 0; i < chrs.length; i++) {
            total += sum;
            res[i] = total;
            sum += chrs[i] - '0';
        }
        sum = 0;
        total = 0;
        for (int i = chrs.length - 1; i >= 0; i--) {
            total += sum;
            res[i] += total;
            sum += chrs[i] - '0';
        }
        return res;
    }
}
