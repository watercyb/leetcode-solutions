/*
 * Problem: 1323. Maximum 69 Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-69-number/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int maximum69Number(int num) {
        char[] chrs = String.valueOf(num).toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '6') {
                chrs[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chrs));
    }
}
