/*
 * Problem: 2566. Maximum Difference by Remapping a Digit
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int minMaxDifference(int num) {
        char[] chrs = String.valueOf(num).toCharArray();
        int max = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] != '9') {
                char t = chrs[i];
                while (i < chrs.length) {
                    if (chrs[i] == t) {
                        max = max * 10 + 9;
                    } else {
                        max = max * 10 + chrs[i] - '0';
                    }
                    i++;
                }
            } else {
                max = max * 10 + chrs[i] - '0';
            }
        }
        int min = 0;
        char t = chrs[0];
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == t) {
                min = min * 10 + 0;
            } else {
                min = min * 10 + chrs[i] - '0';
            }
        }
        return max - min;
    }
}
