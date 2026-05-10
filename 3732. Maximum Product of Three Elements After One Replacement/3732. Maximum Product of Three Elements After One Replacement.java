/*
 * Problem: 3732. Maximum Product of Three Elements After One Replacement
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-product-of-three-elements-after-one-replacement/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long maxProduct(int[] nums) {
        long a = 0;
        long b = 0;
        for (int num : nums) {
            num = Math.abs(num);
            if (num > a) {
                b = a;
                a = num;
            } else if (num > b) {
                b = num;
            }
        }
        return a*b*100000;
    }
}
