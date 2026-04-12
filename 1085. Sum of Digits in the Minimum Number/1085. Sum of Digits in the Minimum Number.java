/*
 * Problem: 1085. Sum of Digits in the Minimum Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-digits-in-the-minimum-number/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int sumOfDigits(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int sum = 0;
        while (min > 0) {
            sum += min % 2;
            min /= 10;
        }
        return 1 - sum % 2;
    }
}
