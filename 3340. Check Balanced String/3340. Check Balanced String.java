/*
 * Problem: 3340. Check Balanced String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-balanced-string/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public boolean isBalanced(String num) {
        int sum = 0;
        int p = 1;
        char[] chrs = String.valueOf(num).toCharArray();
        for (char chr : chrs) {
            sum += p * (chr - '0');
            p = -p;
        }
        return sum == 0;
    }
}
