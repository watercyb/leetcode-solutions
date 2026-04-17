/*
 * Problem: 1422. Maximum Score After Splitting a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int maxScore(String s) {
        char[] chrs = s.toCharArray();
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < chrs.length - 1; i++) {
            sum += chrs[i] - '0';
            int num = i + 1 - 2 * sum;
            if (num > res)
                res = num;
        }
        return res + sum + chrs[chrs.length - 1] - '0';
    }
}
