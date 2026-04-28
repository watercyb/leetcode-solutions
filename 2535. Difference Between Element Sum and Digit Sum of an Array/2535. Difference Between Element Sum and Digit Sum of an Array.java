/*
 * Problem: 2535. Difference Between Element Sum and Digit Sum of an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int differenceOfSum(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += num;
            while (num > 0) {
                res -= num % 10;
                num /= 10;
            }
        }
        return Math.abs(res);
    }
}
