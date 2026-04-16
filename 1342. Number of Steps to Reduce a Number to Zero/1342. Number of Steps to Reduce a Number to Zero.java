/*
 * Problem: 1342. Number of Steps to Reduce a Number to Zero
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num > 1) {
            if (num % 2 == 1) {
                res += 2;
            } else {
                res++;
            }
            num /= 2;
        }
        return res + num;
    }
}
