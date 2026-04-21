/*
 * Problem: 1822. Sign of the Product of an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sign-of-the-product-of-an-array/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num < 0) {
                res = -res;
            } else if (num == 0) {
                return 0;
            }
        }
        return res;
    }
}
